import java.util.*;

public class Nikuldensmeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> guestsBook = new TreeMap<>();

        int unlikedMeals = 0;

        while (!"Stop".equals(input)){
            String[] tokens = input.split("-");
            String type = tokens[0];
            String guestName = tokens[1];
            String meal = tokens[2];

            switch (type){
                case "Like":
                    guestsBook.putIfAbsent(guestName, new ArrayList<>());
                    if (!guestsBook.get(guestName).contains(meal)){
                        guestsBook.get(guestName).add(meal);
                    }

                    break;

                case "Unlike":
                    if (!guestsBook.containsKey(guestName)){
                        System.out.println(String.format("%s is not at the party.", guestName));
                    }else if(!guestsBook.get(guestName).contains(meal)){
                        System.out.println(String.format("%s doesn't have the %s in his/her collection.", guestName, meal));
                    }else {
                        guestsBook.get(guestName).remove(meal);
                        System.out.println(String.format("%s doesn't like the %s.",guestName, meal));
                        unlikedMeals ++;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        guestsBook
                .entrySet()
                .stream()
                .sorted((g1, g2) -> Integer.compare(g2.getValue().size(), g1.getValue().size()))
                .forEach(g -> {
                    System.out.print(String.format("%s: ",g.getKey()));
                    System.out.println(g.getValue().toString().replaceAll("[\\[\\]]", ""));
                });

        System.out.println(String.format("Unliked meals: %d",unlikedMeals));

    }
}
