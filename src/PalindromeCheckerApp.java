
import java.util.Scanner;
class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (ignore spaces and case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        return isPalindrome(normalized);
    }

    // Private helper method (hidden logic)
    private boolean isPalindrome(String str) {

        char[] charArray = str.toCharArray();

        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Application Class (Main Class)
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("===== UC11: Object-Oriented Palindrome Service =====");
        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        boolean result = checker.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}