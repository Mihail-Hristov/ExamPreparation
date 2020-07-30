import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);

        List<Integer> encryptedMassage = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String command = matcher.group("command");
                String message = matcher.group("message");
                for (int j = 0; j < message.length(); j++) {
                    int currentChar = message.charAt(j);
                    encryptedMassage.add(currentChar);
                }
                System.out.print(String.format("%s: ",command));
                System.out.println((encryptedMassage.toString()).replaceAll("[\\[\\],]",""));
            }else {
                System.out.println("The message is invalid");
            }

        }
    }
}
