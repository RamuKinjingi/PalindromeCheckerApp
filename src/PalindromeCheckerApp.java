import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {


    public static boolean isPalindrome(String input) {

        // Remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear elements
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC7: Deque-Based Optimized Palindrome Checker =====");
        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        boolean result = isPalindrome(userInput);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}