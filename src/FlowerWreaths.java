import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> roses = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(roses::push);

        Deque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::offer);

        int forLate = 0;

        int wreaths = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentRose = roses.peek();
            int currentLili = lilies.pop();

            int currentSum = currentRose + currentLili;

            if (currentSum == 15) {
                roses.poll();
                wreaths++;
            }else if (currentSum > 15) {
                currentLili -= 2;
                lilies.push(currentLili);
            }else {
                roses.poll();
                forLate += currentSum;
            }
        }

        wreaths += forLate / 15;

        String output;

        if (wreaths >= 5) {
            output = String.format("You made it, you are going to the competition with %d wreaths!", wreaths);
        }else {
            output = String.format("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }

        System.out.println(output);

    }
}
