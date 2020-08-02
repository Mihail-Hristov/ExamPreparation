import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contents = new HashMap<>();
        Map<String, Map<String, Integer>> submissions = new TreeMap<>();

        String userWithMostPoints = "";
        int mostPointForUser = 0;

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
                submissions.putIfAbsent(username, new HashMap<>());
                submissions.get(username).putIfAbsent(contest, 0);
                if (submissions.get(username).get(contest) < points) {
                    submissions.get(username).put(contest, points);
                }
            }

            secondInput = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> user : submissions.entrySet()) {
            int currentSum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (currentSum > mostPointForUser){
                mostPointForUser = currentSum;
                userWithMostPoints = user.getKey();
            }
        }

        System.out.println(String.format("Best candidate is %s with total %d points.",userWithMostPoints, mostPointForUser));
        System.out.println("Ranking: ");

        submissions
                .forEach((key, value) -> {
                    System.out.println(key);
                    submissions.get(key)
                            .entrySet()
                            .stream()
                            .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                            .forEach((s) -> {
                                System.out.println(String.format("#  %s -> %d", s.getKey(), s.getValue()));
                            });
                });

    }
}
