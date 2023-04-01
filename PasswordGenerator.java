import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}\\|;:'\",.<>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Include uppercase letters? (y/n) ");
        boolean includeUpperCase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n) ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n) ");
        boolean includeSymbols = scanner.nextLine().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUpperCase, includeNumbers, includeSymbols);

        System.out.println("\nGenerated password: " + password);
    }

    private static String generatePassword(int length, boolean includeUpperCase, boolean includeNumbers, boolean includeSymbols) {
        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        String chars = LOWER_CASE;

        if (includeUpperCase) {
            chars += UPPER_CASE;
        }

        if (includeNumbers) {
            chars += NUMBERS;
        }

        if (includeSymbols) {
            chars += SYMBOLS;
        }

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}
