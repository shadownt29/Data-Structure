package Assignment2;

public class DelimiterChecker {

    // O(n) — processes each character once; uses stack to match opening/closing delimiters
    public static boolean check(String input) {
        if (input == null) return true;

        Stack<Character> stack = new Stack<>(Math.max(1, input.length()));

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                Character top = stack.pop();
                if (top == null) return false;
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // Stack must be empty if all openers were matched
        return stack.peek() == null;
    }
}
