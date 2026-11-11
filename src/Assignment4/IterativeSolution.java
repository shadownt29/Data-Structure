package Assignment4;

public class IterativeSolution {

    // O(n), one loop that runs n times
    public static int tri(int n) {
        int tri = 0;
        while (n > 0) {
            tri += n;
            n--;
        }
        return tri;
    }

    // O(n), one loop that runs n times
    public static int fact(int n) {
        int fact = 1;
        while (n > 0) {
            fact *= n;
            n--;
        }
        return fact;
    }

    // O(n), one loop that runs n times
    public static int fib(int n) {
        if (n == 0) return 0;
        int prev = 0;   // fib(0)
        int curr = 1;   // fib(1)
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // O(n), array creation and loop over half the elements scale linearly
    public static String reverseStr(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {
            int targetIndex = arr.length-i-1;

            char temp = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = temp;
        }

        return new String(arr);
    }

    // O(n) worst case, one loop scans the string up to n times
    public static boolean hasChar(String str, char c) {
        if (str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    // O(log n), modulo operation reduces the numbers rapidly
    public static int gcd(int x1, int x2) {
        while (x2 != 0) {
            int temp = x2;
            x2 = x1 % x2;
            x1 = temp;
        }
        return x1;
    }

    // O(m*n), nested loops execute proportional to grid dimensions
    public static int countUniquePaths(int m, int n) {
        int[] grid = new int[n];

        for (int i = 0; i < n; i++) {
            grid[i] = 1;
        }

        for (int i = 1; i < m; i++) { // rows
            for (int j = 1; j < n; j++) { // columns
                grid[j] = grid[j] + grid[j-1];
            }
        }

        return grid[n-1];
    }
}