import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentMassage = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Finish".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Replace" :
                    String currentChar = tokens[1];
                    String newChar = tokens[2];
                    currentMassage = currentMassage.replaceAll(currentChar, newChar);
                    System.out.println(currentMassage);

                    break;

                case "Cut" :
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if ((startIndex < 0 || startIndex >= currentMassage.length()) || (endIndex < 0 || endIndex >= currentMassage.length())){
                        System.out.println("Invalid indexes!");
                    }else {
                        currentMassage = currentMassage.substring(0, startIndex) + currentMassage.substring(endIndex + 1);
                        System.out.println(currentMassage);
                    }

                    break;
                case "Make" :
                    String type = tokens[1];
                    if (type.equals("Upper")){
                        currentMassage = currentMassage.toUpperCase();
                    }else if (type.equals("Lower")){
                        currentMassage = currentMassage.toLowerCase();
                    }
                    System.out.println(currentMassage);

                    break;
                case "Check" :
                    String checkThisString = tokens[1];
                    boolean contains = currentMassage.contains(checkThisString);
                    if (contains){
                        System.out.println(String.format("Message contains %s",checkThisString));
                    }else {
                        System.out.println(String.format("Message doesn't contain %s",checkThisString));
                    }

                    break;
                case "Sum" :
                    int startIndexForSum = Integer.parseInt(tokens[1]);
                    int endIndexForSum = Integer.parseInt(tokens[2]);
                    if ((startIndexForSum < 0 || startIndexForSum >= currentMassage.length()) || (endIndexForSum < 0 || endIndexForSum >= currentMassage.length())){
                        System.out.println("Invalid indexes!");
                    }else {
                        int sum = 0;
                        String tempString = currentMassage.substring(startIndexForSum, endIndexForSum + 1);
                        for (int i = 0; i < tempString.length(); i++) {
                            sum += tempString.charAt(i);
                        }
                        System.out.println(sum);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
    }
}
