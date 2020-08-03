import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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




            input = scanner.nextLine();
        }
    }
}
