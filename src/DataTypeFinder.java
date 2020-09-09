import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"END".equals(input)){
            int integer = 0;
            int floating = 0;
            String type = "string";
            boolean isFloating = false;

            if (input.length() == 1){
                char currentChar = input.charAt(0);
                if (currentChar >= 48 && currentChar <= 57){
                    type = "integer";
                }else {
                    type = "character";
                }
            }else {
                for (int i = 0; i < input.length(); i++) {
                    char currentChar = input.charAt(i);
                    if (i == 0 && currentChar == 45) {
                        integer++;
                    } else if ((currentChar >= 48 && currentChar <= 57) || (i > 0 && currentChar == 46 && i < input.length() - 1)) {
                        integer++;
                        if (currentChar == 46) {
                            floating++;
                            isFloating = true;
                        }
                    }
                }
            }
                String inputToLower = input.toLowerCase();

                if (integer == input.length()) {
                    if (isFloating && floating == 1) {
                        type = "floating point";
                    } else if (floating > 1) {

                    } else {
                        type = "integer";
                    }
                }

                if ("true".equals(inputToLower) || "false".equals(inputToLower)){
                    type = "boolean";
                }

            System.out.println(String.format("%s is %s type", input, type));

            input = scanner.nextLine();
        }
    }
}
