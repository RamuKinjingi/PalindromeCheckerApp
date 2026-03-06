import java.util.*;

public class PalindromeCheckerApp {

    // Stack-based palindrome
    public static boolean stackPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray())
            if (ch != stack.pop()) return false;
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    // Recursive palindrome
    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    // Two-pointer palindrome
    public static boolean twoPointerPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC13: Palindrome Performance Comparison =====");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Stack-based
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long stackTime = System.nanoTime() - startTime;

        // Deque-based
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long dequeTime = System.nanoTime() - startTime;

        // Recursive
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(normalized, 0, normalized.length() - 1);
        long recursiveTime = System.nanoTime() - startTime;

        // Two-pointer
        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        long twoPointerTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\nAlgorithm Results:");
        System.out.printf("Stack-based: %s | Time: %d ns\n", stackResult, stackTime);
        System.out.printf("Deque-based: %s | Time: %d ns\n", dequeResult, dequeTime);
        System.out.printf("Recursive : %s | Time: %d ns\n", recursiveResult, recursiveTime);
        System.out.printf("Two-pointer: %s | Time: %d ns\n", twoPointerResult, twoPointerTime);

        scanner.close();
    }
}