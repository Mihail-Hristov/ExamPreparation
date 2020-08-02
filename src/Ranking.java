import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contents = new HashMap<>();
        Map<String, Map<String, Integer>> submissions = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"end of contests".equals(input)) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];

            contents.putIfAbsent(contest,password);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!"end of submissions".equals(secondInput)){
            String[] tokens = secondInput.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contents.containsKey(contest) && contents.get(contest).equals(password)){

            }

            secondInput = scanner.nextLine();
        }

    }
}
