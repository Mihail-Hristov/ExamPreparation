import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tasks = scanner.nextLine().split(", ");
        String[] threads = scanner.nextLine().split("\\s+");

        Deque<Integer> stackForTasks = new ArrayDeque<>();
        Deque<Integer> dequeForThreads = new ArrayDeque<>();

        Arrays.stream(tasks).mapToInt(Integer::parseInt)
                .forEach(stackForTasks::push);

        Arrays.stream(threads).mapToInt(Integer::parseInt)
                .forEach(dequeForThreads::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        int threadThatKill = -1;

        while (!stackForTasks.isEmpty()) {
            int currentTask = stackForTasks.peek();
            int currentThread = dequeForThreads.poll();

            if (currentThread >= currentTask) {
                stackForTasks.pop();
                if (currentTask == taskToBeKilled) {
                    threadThatKill = currentThread;
                    break;
                }
            }else {
                if (currentTask == taskToBeKilled) {
                    threadThatKill = currentThread;
                    break;
                }
            }

        }

        System.out.println(String.format("Thread with value %d killed task %d", threadThatKill, taskToBeKilled));

        StringBuilder result = new StringBuilder();
        result.append(threadThatKill);
        if (!dequeForThreads.isEmpty()) {
            dequeForThreads.forEach(e -> result.append(" ").append(e));
        }
        System.out.println(result.toString());
    }
}
