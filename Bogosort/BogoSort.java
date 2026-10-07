package Bogosort;

import java.util.Random;

class BogoSort {
    static long comparisons = 0;
    static long swaps = 0;
    static Random random = new Random();

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            comparisons++;
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            int ranIndex = random.nextInt(i + 1);
            int temp = arr[ranIndex];
            arr[ranIndex] = arr[i];
            arr[i] = temp;
            swaps++;
        }
    }

    public static long[] sort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        long attempts = 0;
        long startTime = System.nanoTime();

        while (!isSorted(arr)) {
            shuffle(arr);
            attempts++;
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new long[]{attempts, comparisons, swaps, (long)(timeMs * 1000)};
    }
}

class BubbleSort {
    public static long[] sort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new long[]{comparisons, swaps, (long)(timeMs * 1000)};
    }
}

class SelectionSort {
    public static long[] sort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            swaps++;
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new long[]{comparisons, swaps, (long)(timeMs * 1000)};
    }
}

class InsertionSort {
    public static long[] sort(int[] arr) {
        long comparisons = 0;
        long swaps = 0;
        long startTime = System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            comparisons++;
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        return new long[]{comparisons, swaps, (long)(timeMs * 1000)};
    }
}