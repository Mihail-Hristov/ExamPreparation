import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"no more time".equals(input)){
            String[] tokens = input.split("->");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            contests.putIfAbsent(contest, new TreeMap<>());
            contests.get(contest).putIfAbsent(username, 0);
            if (!contests.get(contest).containsKey(username)){
                contests.get(contest).put(username, points);
            }else{
                if(contests.get(contest).get(username) < points){
                    contests.get(contest).put(username, points);
                }
            }


            input = scanner.nextLine();
        }
    }
}
