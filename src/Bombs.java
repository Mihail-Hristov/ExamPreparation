import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> dequeForEffects = new ArrayDeque<>();
        Deque<Integer> stackForCasings = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(dequeForEffects::offer);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackForCasings::push);

        int countDaturaBombs = 0;
        int countCherryBombs = 0;
        int countSmokeDecoyBombs = 0;

        boolean haveBombPouch = false;

        while (!dequeForEffects.isEmpty() && !stackForCasings.isEmpty() && !haveBombPouch) {
            int currentSum = dequeForEffects.peek() + stackForCasings.peek();
            if (currentSum == 40) {
                dequeForEffects.poll();
                stackForCasings.pop();
                countDaturaBombs ++;
            }else if (currentSum == 60) {
                dequeForEffects.poll();
                stackForCasings.pop();
                countCherryBombs ++;
            } else if (currentSum == 120) {
                dequeForEffects.poll();
                stackForCasings.pop();
                countSmokeDecoyBombs ++;
            }else {
                int currentCas = stackForCasings.pop();
                stackForCasings.push(currentCas - 5);
            }

            if (countDaturaBombs >= 3 && countCherryBombs >= 3 && countSmokeDecoyBombs >= 3) {
                haveBombPouch = true;
            }
        }

        if (haveBombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (dequeForEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");
            List<Integer> deque = new ArrayList<>();
            while (!dequeForEffects.isEmpty()) {
             deque.add(dequeForEffects.poll());
            }
            int index = deque.size() - 1;
            for (int i = 0; i < deque.size(); i++) {
                if (index == i) {
                    System.out.println(deque.get(i));
                }else {
                    System.out.print(deque.get(i) + ", ");
                }
            }
        }

        if (stackForCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: ");
            List<Integer> stack = new ArrayList<>();
            while (!stackForCasings.isEmpty()) {
                stack.add(stackForCasings.pop());
            }
            int index = stack.size() - 1;
            for (int i = 0; i < stack.size(); i++) {
                if (index == i) {
                    System.out.println(stack.get(i));
                }else {
                    System.out.print(stack.get(i) + ", ");
                }
            }
        }

        System.out.println(String.format("Cherry Bombs: %d", countCherryBombs));
        System.out.println(String.format("Datura Bombs: %d", countDaturaBombs));
        System.out.println(String.format("Smoke Decoy Bombs: %d", countSmokeDecoyBombs));

    }
}
