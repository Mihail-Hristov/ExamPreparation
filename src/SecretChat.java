import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String massage = scanner.nextLine();

        String input = scanner.nextLine();

        while (!"Reveal".equals(input)){
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command){
                case "InsertSpace":
                    int indexForSpace = Integer.parseInt(tokens[1]);
                    massage = insertSpace(massage, indexForSpace);

                    break;
                case "Reverse":
                    String substringForReplace = tokens[1];
                    massage = reverseInMassage(massage, substringForReplace);

                    break;
                case "ChangeAll":
                    String subStringForReplace = tokens[1];
                    String replaceWith = tokens[2];
                    massage = changeAll(massage, subStringForReplace,replaceWith);

                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("You have a new text message: %s", massage));
    }

    public static String insertSpace(String massage, int index){
        if (index == 0){
            massage = " " + massage;
        }else {
            massage = massage.substring(0, index) + " " + massage.substring(index);
        }
        System.out.println(massage);
        return massage;
    }

    public static String reverseInMassage(String massage, String substring){
        if (massage.contains(substring)){
            massage = massage.replaceFirst(substring, "").concat(new StringBuilder(substring).reverse().toString());
            System.out.println(massage);
            return massage;
        }else {
            System.out.println("error");
            return massage;
        }
    }

    public static String changeAll(String massage, String oldSub, String newSub){
        massage = massage.replaceAll(oldSub, newSub);
        System.out.println(massage);
        return massage;
    }
}
