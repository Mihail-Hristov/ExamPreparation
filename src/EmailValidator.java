import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Complete".equals(input)){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command){
                case "Make":
                    String toCase = tokens[1];
                    email = makeUpperOrLowerCase(email,toCase);

                    break;

                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    getDomain(email, count);

                    break;

                case "GetUsername":
                    getUsername(email);

                    break;

                case "Replace":
                    char charForReplace = tokens[1].charAt(0);
                    replaceChar(email, charForReplace);

                    break;

                case "Encrypt":
                    encrypt(email);

                    break;
            }

            input = scanner.nextLine();
        }

    }

    public static String makeUpperOrLowerCase(String email, String type){
        if ("Upper".equals(type)){
            email = email.toUpperCase();
        } else if ("Lower".equals(type)) {
            email = email.toLowerCase();
        }
        System.out.println(email);
        return email;
    }

    public static void getDomain(String email, int count){
        StringBuilder currentMessage = new StringBuilder();
        int startIndex = email.length() - count;
        for (int i = startIndex; i < email.length(); i++) {
            currentMessage.append(email.charAt(i));
        }
        System.out.println(currentMessage);
    }

    public static void getUsername(String email){
        if (!email.contains("@")){
            System.out.println(String.format("The email %s doesn't contain the @ symbol.",email));
        }else {
            int toIndex = email.indexOf('@');
            String tempSubstring = email.substring(0,toIndex);
            System.out.println(tempSubstring);
        }
    }

    public static String replaceChar(String email, char charForReplace){
        email = email.replaceAll(String.valueOf(charForReplace), "-");
        System.out.println(email);
        return email;
    }

    public static void encrypt(String email){
        List<Integer> encryptedChar = new ArrayList<>();
        for (int i = 0; i < email.length(); i++) {
            int current = email.charAt(i);
            encryptedChar.add(current);
        }

        System.out.println(encryptedChar.toString().replaceAll("[\\[\\],]", ""));
    }
}
