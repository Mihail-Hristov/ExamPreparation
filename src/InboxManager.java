import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sentEmails = new TreeMap<>();

        String input = scanner.next();
        while (!"Statistics".equals(input)){
            String[] tokens = input.split("->");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String username = tokens[1];
                    chekForExistUsernameAndAdd(sentEmails,username);

                    break;
                case "Send":
                    String usernameForSend = tokens[1];
                    String email = tokens[2];
                    addEmailToUserCollections(sentEmails, usernameForSend, email);

                    break;
                case "Delete":
                    String usernameForDelete = tokens[1];
                    deleteUser(sentEmails, usernameForDelete);

                    break;

            }

            input = scanner.next();
        }

        int countUsername = sentEmails.size();
        System.out.println(String.format("Users count: %d",countUsername));

        sentEmails
                .entrySet()
                .stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .forEach(s -> {
                    System.out.println(s.getKey());
                    for (String item : s.getValue()) {
                        System.out.println(" - " + item);
                    }
                });

    }

    public static void chekForExistUsernameAndAdd(Map<String, List<String>> sentEmails, String username){
        if (sentEmails.containsKey(username)){
            System.out.println(String.format("%s is already registered",username));
        }else {
            sentEmails.put(username, new ArrayList<>());
        }
    }

    public static void addEmailToUserCollections(Map<String, List<String>> sentEmails, String username, String email){
        sentEmails.get(username).add(email);
    }

    public static void deleteUser(Map<String,List<String>> sentEmail, String username){
        if (sentEmail.containsKey(username)){
            sentEmail.remove(username);
        }else {
            System.out.println(String.format("$s  not found!",username));
        }
    }
}
