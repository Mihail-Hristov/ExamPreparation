import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = scanner.nextByte();
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[\\d]+)P@\\$";
        Pattern pattern = Pattern.compile(regex);

        int countSuccessfulRegistrations = 0;

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s",username, password));
                countSuccessfulRegistrations ++;
            }else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.println(String.format("Successful registrations: %d",countSuccessfulRegistrations));
    }
}
