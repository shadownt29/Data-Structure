package Assignment2;

public class StringReverser {

    // O(n) — pushes each character onto a stack, then pops to build reversed string
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) return input;

        Stack<Character> stack = new Stack<>(input.length());
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        Character c;
        while ((c = stack.pop()) != null) {
            sb.append(c);
        }
        return sb.toString();
    }
}
