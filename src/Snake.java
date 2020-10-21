import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());

        char[][] gameTerritory = new char[rows][];
        int[] snakePosition = new int[2];
        List<Integer> lair = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            gameTerritory[row] = readCurrentCol(scanner);
            for (int col = 0; col < gameTerritory[row].length; col++) {
                if (gameTerritory[row][col] == 'S') {
                    snakePosition[0] = row;
                    snakePosition[1] = col;
                }else if (gameTerritory[row][col] == 'B') {
                    lair.add(row);
                    lair.add(col);
                }
            }
        }

        int snakeFet = 0;

        boolean gameEnd = false;
        boolean gameOver = false;
        ;

        while (!gameEnd) {
            String command = scanner.nextLine();

            gameTerritory[snakePosition[0]][snakePosition[1]] = '.';
            switch (command) {
                case "up":
                    if (chekForValidField(snakePosition, gameTerritory, command)) {
                        if (gameTerritory[snakePosition[0] - 1][snakePosition[1]] == '*') {
                            snakeFet++;
                            snakePosition[0] -= 1;
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else if (gameTerritory[snakePosition[0] - 1][snakePosition[1]] == 'B') {
                            gameTerritory[snakePosition[0] - 1][snakePosition[1]] = '.';
                            if (snakePosition[0] - 1 == lair.get(0) && snakePosition[1] == lair.get(1)) {
                                snakePosition[0] = lair.get(2);
                                snakePosition[1] = lair.get(3);
                            }else {
                                snakePosition[0] = lair.get(0);
                                snakePosition[1] = lair.get(1);
                            }
                            lair.clear();
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else {
                            snakePosition[0] -= 1;
                        }
                    } else {
                        gameOver = true;
                        gameEnd = true;
                    }

                    break;
                case "down":
                    if (chekForValidField(snakePosition, gameTerritory, command)) {
                        if (gameTerritory[snakePosition[0] + 1][snakePosition[1]] == '*') {
                            snakeFet++;
                            snakePosition[0] += 1;
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else if (gameTerritory[snakePosition[0] + 1][snakePosition[1]] == 'B') {
                            gameTerritory[snakePosition[0] + 1][snakePosition[1]] = '.';
                            if (snakePosition[0] + 1 == lair.get(0) && snakePosition[1] == lair.get(1)) {
                                snakePosition[0] = lair.get(2);
                                snakePosition[1] = lair.get(3);
                            }else {
                                snakePosition[0] = lair.get(0);
                                snakePosition[1] = lair.get(1);
                            }
                            lair.clear();
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else {
                            snakePosition[0] += 1;
                        }
                    } else {
                        gameOver = true;
                        gameEnd = true;
                    }

                    break;
                case "left":
                    if (chekForValidField(snakePosition, gameTerritory, command)) {
                        if (gameTerritory[snakePosition[0]][snakePosition[1] - 1] == '*') {
                            snakeFet++;
                            snakePosition[1] -= 1;
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else if (gameTerritory[snakePosition[0]][snakePosition[1] - 1] == 'B') {
                            gameTerritory[snakePosition[0]][snakePosition[1] - 1] = '.';
                            if (snakePosition[0] == lair.get(0) && snakePosition[1] - 1 == lair.get(1)) {
                                snakePosition[0] = lair.get(2);
                                snakePosition[1] = lair.get(3);
                            }else {
                                snakePosition[0] = lair.get(0);
                                snakePosition[1] = lair.get(1);
                            }
                            lair.clear();
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else {
                            snakePosition[1] -= 1;
                        }
                    } else {
                        gameOver = true;
                        gameEnd = true;
                    }

                    break;
                case "right":
                    if (chekForValidField(snakePosition, gameTerritory, command)) {
                        if (gameTerritory[snakePosition[0]][snakePosition[1] + 1] == '*') {
                            snakeFet++;
                            snakePosition[1] += 1;
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else if (gameTerritory[snakePosition[0]][snakePosition[1] + 1] == 'B') {
                            gameTerritory[snakePosition[0]][snakePosition[1] + 1] = '.';
                            if (snakePosition[0] == lair.get(0) && snakePosition[1] + 1 == lair.get(1)) {
                                snakePosition[0] = lair.get(2);
                                snakePosition[1] = lair.get(3);
                            }else {
                                snakePosition[0] = lair.get(0);
                                snakePosition[1] = lair.get(1);
                            }
                            lair.clear();
                            gameTerritory[snakePosition[0]][snakePosition[1]] = 'S';
                        }else {
                            snakePosition[1] += 1;
                        }
                    } else {
                        gameOver = true;
                        gameEnd = true;
                    }

                    break;
            }

            if (snakeFet >= 10) {
                gameEnd = true;
            }
        }

        if (gameOver) {
            System.out.println("Game over!");
        }else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.println(String.format("Food eaten: %d", snakeFet));


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < gameTerritory[row].length; col++) {
                System.out.print(gameTerritory[row][col]);
            }
            System.out.println();
        }
    }

    private static char[] readCurrentCol(Scanner scanner) {
        String[] temp = scanner.nextLine().split("");
        char[] result = new char[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i].charAt(0);
        }
        return result;
    }

    private static boolean chekForValidField(int[] snakePosition, char[][] gameTerritory, String command) {
        boolean result = false;
        int snakeRow = snakePosition[0];
        int snakeCol = snakePosition[1];

        switch (command) {
            case "up":
                if (snakeRow - 1 >= 0) {
                result = true;
            }
            break;

            case "down":
                if (snakeRow + 1 < gameTerritory.length) {
                    result = true;
                }
                break;
            case "left":
                if (snakeCol - 1 >= 0) {
                    result = true;
                }
                break;
            case "right":
                if (snakeCol + 1 < gameTerritory.length) {
                    result = true;
                }
                break;
        }
        return result;
    }

}
