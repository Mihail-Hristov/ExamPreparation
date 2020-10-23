import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bee {
    static int beeRow;
    static int beeCol;
    static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] beeTerritory = new char[size][size];


        for (int row = 0; row < size; row++) {
            String[] inputtedLine = scanner.nextLine().split("");
            for (int col = 0; col < inputtedLine.length; col++) {
                beeTerritory[row][col] = inputtedLine[col].charAt(0);
                if (beeTerritory[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        boolean goOut = false;

        String command = scanner.nextLine();

        while (!"End".equals(command) && !goOut) {
            int currentRow = beeRow;
            int currentCol = beeCol;

            beeTerritory[beeRow][beeCol] = '.';
            switch (command) {
                case "up":
                    if (checkForOutOfTerritory(currentRow - 1, beeTerritory)) {
                        goOut = true;
                    } else {
                        if (movedBeeWithBonus(currentRow - 1, currentCol, beeTerritory)) {
                            continue;
                        }
                    }
                    break;
                case "down":
                    if (checkForOutOfTerritory(currentRow + 1, beeTerritory)) {
                        goOut = true;
                    } else {
                        if (movedBeeWithBonus(currentRow + 1, currentCol, beeTerritory)) {
                            continue;
                        }
                    }
                    break;
                case "left":
                    if (checkForOutOfTerritory(currentCol - 1, beeTerritory)) {
                        goOut = true;
                    } else {
                        if (movedBeeWithBonus(currentRow, currentCol - 1, beeTerritory)) {
                            continue;
                        }
                    }
                    break;
                case "right":
                    if (checkForOutOfTerritory(currentCol + 1, beeTerritory)) {
                        goOut = true;
                    } else {
                        if (movedBeeWithBonus(currentRow, currentCol + 1, beeTerritory)) {
                            continue;
                        }
                    }
                    break;
            }

            if (!goOut) {
                command = scanner.nextLine();
            }
        }

        if (goOut) {
            System.out.println("The bee got lost!");
        }

        String output;
        if (pollinatedFlowers >= 5) {
            output = String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers);
        } else {
            output = String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers);
        }

        System.out.println(output);
        printTheBeeTerritory(beeTerritory);
    }

    private static boolean movedBeeWithBonus(int newRow, int newCol, char[][] territory) {
        if (territory[newRow][newCol] == 'f') {
            pollinatedFlowers++;
            territory[newRow][newCol] = 'B';
            beeRow = newRow;
            beeCol = newCol;
        } else if (territory[newRow][newCol] == 'O') {
            beeRow = newRow;
            beeCol = newCol;
            return true;
        } else {
            territory[newRow][newCol] = 'B';
            beeRow = newRow;
            beeCol = newCol;
        }
        return false;
    }

    private static void printTheBeeTerritory(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkForOutOfTerritory(int newIndex, char[][] territory) {
        if (newIndex < 0 || newIndex > territory.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}