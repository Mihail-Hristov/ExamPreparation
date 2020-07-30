import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputtedString = scanner.next();

        String input = scanner.nextLine();
        while (!"Finish".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Replace" : break;
                case "Cut" : break;
                case "Make" : break;
                case "Check" : break;
                case "Sum" : break;

            }


            input = scanner.nextLine();
        }
    }
}
