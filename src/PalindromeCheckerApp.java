
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input, int start, int end) {

        // Base Condition: If pointers cross or are equal
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call moving towards center
        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC9: Recursive Palindrome Checker =====");
        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        // Remove spaces and convert to lowercase
        userInput = userInput.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(userInput, 0, userInput.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}