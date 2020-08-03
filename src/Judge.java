import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> users = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"no more time".equals(input)){
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            users.putIfAbsent(username, 0);

            contests.putIfAbsent(contest, new TreeMap<>());
            contests.get(contest).putIfAbsent(username, 0);
            if (!contests.get(contest).containsKey(username)){
                contests.get(contest).put(username, points);
                users.put(username, users.get(username) + points);
            }else{
                if(contests.get(contest).get(username) < points){
                    contests.get(contest).put(username, points);
                    users.put(username, users.get(username) + points);
                }
            }

            input = scanner.nextLine();
        }

        contests
                .entrySet()
                .stream()
                .forEach(c -> {
                    Integer count = (int) c.getValue().values().stream().mapToInt(i -> i).count();
                    System.out.println(String.format("%s: %d participants",c.getKey(), count));
                    AtomicReference<Integer> position = new AtomicReference<>(0);
                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((u1,u2) -> Integer.compare(u2.getValue(), u1.getValue()))
                            .forEach(u -> {
                                position.getAndSet(position.get() + 1);
                                System.out.println(String.format("%d. %s <::> %d", position.get(),u.getKey(), u.getValue()));
                            });
                });

        System.out.println("Individual standings:");
        var lambdaContext = new Object() {
            Integer temp = 0;
        };
        users
                .entrySet()
                .stream()
                .sorted((u1, u2) -> u2.getValue().compareTo(u1.getValue()))
                .forEach(u -> {
                    lambdaContext.temp += 1;
                    System.out.println(String.format("%d. %s -> %d", lambdaContext.temp, u.getKey(), u.getValue()));
                });

    }
}
