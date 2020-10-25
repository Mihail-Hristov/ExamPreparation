import java.util.*;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfFiled = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(sizeOfFiled[0]);
        int cols = Integer.parseInt(sizeOfFiled[1]);

        int[][] field = new int[rows][cols];

        printTheField(field);

        createTheField(field);

        String input = scanner.nextLine();

        while (!"Bloom Bloom Plow".equals(input)) {
            String[] tokens = input.split("\\s+");
            int currentRow = Integer.parseInt(tokens[0]);
            int currentCol = Integer.parseInt(tokens[1]);

            if (positionIsOutOfBounds(currentRow, currentCol, field)) {
                System.out.println("Invalid coordinates.");
            }else {
                field[currentRow][currentCol] ++;
            }

            input = scanner.nextLine();
        }

        bloomsFlowers(field);

        printTheField(field);
    }

    public static void createTheField(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            Arrays.fill(matrix[row], 0);
        }
    }

    public static boolean positionIsOutOfBounds(int row, int col, int[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    public static void bloomsFlowers(int[][] matrix) {
        Deque<int[]> flowersCoordinate = new ArrayDeque<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    int[] currentPosition = new int[]{row, col};
                    flowersCoordinate.offer(currentPosition);
                }
            }
        }
        while (!flowersCoordinate.isEmpty()) {
            int[] currentPosition = flowersCoordinate.poll();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];
            for (int col = 0; col < matrix.length; col++) {
                if (col != currentCol) {
                    matrix[currentRow][col] ++;
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                if (row != currentRow) {
                    matrix[row][currentCol] ++;
                }
            }
        }

    }

    public static void printTheField(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == 0) {
                    System.out.print(matrix[row][col]);
                }else {
                    System.out.print(" " + matrix[row][col]);
                }
            }
            System.out.println();
        }
    }
}
