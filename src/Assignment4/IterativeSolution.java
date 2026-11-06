package Assignment4;

import java.util.Arrays;

public class IterativeSolution {
    // Triangle Number
    public static int tri(int n) {
        int tri = 0;
        while (n > 0) {
            tri += n;
            n--;
        }
        return tri;
    }

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

    public static String reverseStr(String str) {
        if (str.length() <= 1) {
            return str;
        }
        // put char of the string in an array
        char[] arr = str.toCharArray();
        // reverse
        for (int i = 0; i < arr.length / 2; i++) {
            int targetIndex = arr.length-i-1;

            char temp = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = temp;
        }

        return new String(arr);
    }

    public static boolean hasChar(String str, char c) {
        if (str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public static int gcd(int x1, int x2) {
        // Keep looping until x2 becomes 0
        while (x2 != 0) {
            int temp = x2;
            x2 = x1 % x2; // Get the remainder
            x1 = temp;    // Shift x1 to the old x2
        }
        return x1; // x1 holds the GCD
    }


    // Unique Paths
    // O(m x n) - 
    public static int countUniquePaths(int m, int n) {
        int[] grid = new int[n]; // first row (1 x n) grid

        // base case: 1 way to reach any cell in the 1st row
        for (int i = 0; i < n; i++) {
            grid[i] = 1;
        }

        // iterate through the rest of the rows
        for (int i = 1; i < m; i++) { // rows
            for (int j = 1; j < n; j++) { // columns
                grid[j] = grid[j] + grid[j-1];
            }
        }

        return grid[n-1];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
//        System.out.println(tri(0));
//        System.out.println(fact(0));
//        System.out.println(fib(6));
//        System.out.println(reverseStr("nigger"));
//        System.out.println(hasChar("bird", 'z'));
        System.out.println(gcd(3, 1));
//        System.out.printf("The total unique path(s) of %d by %d is %d.",m ,n ,countUniquePaths(m,n));
    }
}
