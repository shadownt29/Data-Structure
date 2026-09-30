package Bogosort;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = random.nextInt(1, 101);
        return arr;
    }

    public static void main(String[] args) {
        int size = 5;
        String sizeName = "";
        if (size == 5) {
            sizeName = "small";
        } else if (size == 1000) {
            sizeName = "medium";
        } else if (size == 1000000) {
            sizeName = "large";
        }
        int[] original = generateArray(size);

        StringBuilder output = new StringBuilder();

        output.append("=== Sorting Algorithm Performance Report ===\n");
        output.append("Algorithm under study: Bogo Sort\n");
        output.append("Compared against: Bubble Sort, Selection Sort, Insertion Sort\n");
        output.append("Original: ").append(Arrays.toString(original)).append("\n\n");
        output.append(String.format("---- Dataset: %s (n = %d) ----\n", sizeName, size));

        int[] arr1 = original.clone();
        long[] bogo = BogoSort.sort(arr1);
        output.append(String.format("Bogo Sort      | Attempts: %6d | Comparisons: %6d | Swaps: %6d | Runtime: %.3f ms%n",
                bogo[0], bogo[1], bogo[2], bogo[3] / 1000.0));

        int[] arr2 = original.clone();
        long[] bubble = BubbleSort.sort(arr2);
        output.append(String.format("Bubble Sort    | Comparisons: %6d | Swaps/Movements: %6d | Runtime: %.3f ms%n",
                bubble[0], bubble[1], bubble[2] / 1000.0));

        int[] arr3 = original.clone();
        long[] selection = SelectionSort.sort(arr3);
        output.append(String.format("Selection Sort | Comparisons: %6d | Swaps/Movements: %6d | Runtime: %.3f ms%n",
                selection[0], selection[1], selection[2] / 1000.0));

        int[] arr4 = original.clone();
        long[] insertion = InsertionSort.sort(arr4);
        output.append(String.format("Insertion Sort | Comparisons: %6d | Swaps/Movements: %6d | Runtime: %.3f ms%n",
                insertion[0], insertion[1], insertion[2] / 1000.0));

        output.append("\n");
        output.append("BogoSorted: ").append(Arrays.toString(arr1)).append("\n");
        output.append("Bubble Sorted: ").append(Arrays.toString(arr2)).append("\n");
        output.append("Selection Sorted: ").append(Arrays.toString(arr3)).append("\n");
        output.append("Insertion Sorted: ").append(Arrays.toString(arr4)).append("\n\n");
        output.append("Note: Bogo Sort is not tested at n=1,000 and n=1,000,000\n");
        output.append("due to O(n x n!) complexity making it computationally infeasible.\n");

        // Print to console
        System.out.print(output.toString());

        // Write to performance.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("performance.txt"))) {
            writer.print(output.toString());
            System.out.println("-> Results successfully saved to performance.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}