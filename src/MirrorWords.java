import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPairs = 0;
        List<String> mirrorWords = new ArrayList<>();

        String inputText = scanner.nextLine();
        String regex = "([@#]{1})(?<first>[A-Za-z]{3,})(\\1){2}(?<second>[A-Za-z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            countPairs++;
            if (firstWord.equals(new StringBuilder(secondWord).reverse().toString())) {
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }
        }
        if (countPairs == 0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }else {
            System.out.println(String.format("%d word pairs found!", countPairs));
            if (mirrorWords.size() > 0) {
                System.out.println("The mirror words are:");
                System.out.println(mirrorWords.toString().replaceAll("[\\[\\]]", ""));
            } else {
                System.out.println("No mirror words!");
            }
        }
    }
}
