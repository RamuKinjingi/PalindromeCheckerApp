import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args) {


        String input = "MADAM";

        Queue<Character> queue = new LinkedList<>();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {

            char fromQueue = queue.remove(); //FIFO
            char fromStack = stack.pop();     // LIFO

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}