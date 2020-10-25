import java.util.Arrays;
import java.util.Scanner;

public class ReVolt {
    static int playerRow;
    static int playerCol;
    static boolean findFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                field[row][col] = input[col].charAt(0);
                if (field[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        for (int i = 0; i < numberOfCommands; i++) {
            if (findFinish) {
                break;
            }
            String command = scanner.nextLine();
            int currentRowIndex = playerRow;
            int currentColIndex = playerCol;

            field[currentRowIndex][currentColIndex] = '-';
            switch (command) {
                case "up":
                    if (checkForGoOut(currentRowIndex - 1, field)) {
                        currentRowIndex = field.length;
                    }
                    playerMoving(currentRowIndex - 1, currentColIndex, field, command);

                    break;
                case "down":
                    if (checkForGoOut(currentRowIndex + 1, field)) {
                        currentRowIndex = -1;
                    }
                    playerMoving(currentRowIndex + 1, currentColIndex, field, command);

                    break;
                case "left":
                    if (checkForGoOut(currentColIndex - 1, field)) {
                        currentColIndex = field.length;
                    }
                    playerMoving(currentRowIndex , currentColIndex - 1, field, command);

                    break;
                case "right":
                    if (checkForGoOut(currentColIndex + 1, field)) {
                        currentColIndex = -1;
                    }
                    playerMoving(currentRowIndex , currentColIndex + 1, field, command);

                    break;
            }
        }

        if (findFinish) {
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }

        printTheFiled(field);
    }

    private static void printTheFiled(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkForGoOut(int newIndex, char[][] field) {
        return newIndex < 0 || newIndex >= field.length;
    }

    private static void playerMoving(int newRowIndex, int newColIndex, char[][] field, String command) {
        if (field[newRowIndex][newColIndex] == 'B') {
            if (command.equals("up")) {
                newRowIndex --;
                if (checkForGoOut(newRowIndex, field)) {
                    newRowIndex = field.length - 1;
                }
            }else if (command.equals("down")) {
                newRowIndex ++;
                if (checkForGoOut(newRowIndex, field)) {
                    newRowIndex = 0;
                }
            } else if (command.equals("left")) {
                newColIndex --;
                if (checkForGoOut(newColIndex, field)) {
                    newColIndex = field.length - 1;
                }
            } else if (command.equals("right")) {
                newColIndex ++;
                if (checkForGoOut(newColIndex, field)) {
                    newColIndex = 0;
                }
            }
        } else if (field[newRowIndex][newColIndex] == 'T') {
            if (command.equals("up")) {
                newRowIndex ++;
                if (checkForGoOut(newRowIndex, field)) {
                    newRowIndex = 0;
                }
            }else if (command.equals("down")) {
                newRowIndex --;
                if (checkForGoOut(newRowIndex, field)) {
                    newRowIndex = field.length - 1;
                }
            } else if (command.equals("left")) {
                newColIndex++;
                if (checkForGoOut(newColIndex, field)) {
                    newColIndex = 0;
                }
            }else if (command.equals("right")) {
                newColIndex --;
                if (checkForGoOut(newColIndex, field)) {
                    newColIndex = field.length - 1;
                }
            }
        }else if (field[newRowIndex][newColIndex] == 'F') {
            findFinish = true;
        }else if (field[newRowIndex][newColIndex] == '-') {
        }
        field[newRowIndex][newColIndex] = 'f';
        playerRow = newRowIndex;
        playerCol = newColIndex;
    }
}
