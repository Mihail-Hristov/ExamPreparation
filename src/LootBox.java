import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> dequeForFirstBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(dequeForFirstBox::offer);

        Deque<Integer> stackForSecondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackForSecondBox::push);

        int claimedItem = 0;

        while (!dequeForFirstBox.isEmpty() && !stackForSecondBox.isEmpty()) {
            int currentSumFromFirstBox = dequeForFirstBox.peek();
            int currentSumFromSecondBox = stackForSecondBox.pop();

            int currentSum = currentSumFromFirstBox + currentSumFromSecondBox;

            if (currentSum % 2 == 0) {
                claimedItem += currentSum;
                dequeForFirstBox.poll();
            }else {
                dequeForFirstBox.offer(currentSumFromSecondBox);
            }
        }

        if (dequeForFirstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItem >= 100) {
            System.out.println(String.format("Your loot was epic! Value: %d", claimedItem));
        }else {
            System.out.println(String.format("Your loot was poor... Value: %d", claimedItem));
        }


    }
}
