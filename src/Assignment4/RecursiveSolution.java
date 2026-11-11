package Assignment4;

public class RecursiveSolution {

    // O(n), it calls itself n times and each call just adds
    public static int tri(int n) {
        if (n <= 0) { // base case
            return 0;
        } else if (n == 1) { // base case
            return 1;
        }
        return tri(n - 1) + n; // recursive step
    }

    // O(n), it calls itself n times and each call just multiplies
    public static int fact(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return fact(n - 1) * n; // recursive step
    }

    // O(2^n), every call makes 2 more calls and it repeats the same work a lot
    public static int fib(int n) {
        if (n == 0) return 0; // base case
        if (n == 1) return 1; // base case
        return fib(n - 1) + fib(n - 2); // recursive step
    }

    // O(n^2), n calls, and substring copies the string each time
    public static String reverseStr(String str) {
        if (str.length() <= 1) { // base case
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0); // recursive step
    }

    // O(n^2) worst case, n calls, and substring copies the string each time
    public static boolean hasChar(String str, char c) {
        if (str.isEmpty()) { // base case
            return false;
        } else if (str.charAt(0) == c) { // base case
            return true;
        } else {
            return hasChar(str.substring(1), c); // recursive step
        }
    }

    // O(log n), the numbers get smaller really fast each call
    public static int gcd(int x1, int x2) {
        if (x2 == 0) { // base case
            return x1;
        }
        return gcd(x2, x1 % x2); // recursive step
    }

    // O(2^(m+n)), every call makes 2 more calls and it goes about m+n deep
    public static int countUniquePaths(int m, int n) {
        if (n <= 0 || m <= 0) { // base case
            return 0;
        } else if (n == 1 || m == 1) { // base case
            return 1;
        } else {
            return countUniquePaths(m - 1, n) + countUniquePaths(m, n - 1); // recursive step
        }
    }
}
