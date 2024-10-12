import java.util.Scanner;

public class IdentifyCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character : ");
        char character = scanner.nextLine().charAt(0);
        scanner.close();

        System.out.println(character);

        if (Character.isDigit(character)) {
            System.out.println("Numeric");
            return;
        }

        if (Character.isLetter(character)) {
            System.out.println("Letters");
            return;
        }

        if (Character.isSpaceChar(character)) {
            System.out.println("Space");
            return;
        }

        System.out.println("Punctuation Mark");
    }
}
