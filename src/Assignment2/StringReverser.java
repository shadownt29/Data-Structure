package Assignment2;

public class StringReverser {

    // O(n) — pushes each character onto a stack, then pops to get the reversed string
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) return input;

        Stack<Character> stack = new Stack<>(input.length());
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        char[] result = new char[input.length()];
        int i = 0;
        Character c;
        while ((c = stack.pop()) != null) {
            result[i++] = c;
        }
        return new String(result);
    }
}
