package Assignment1.GenericClass;

public class OrderedArray<T extends Comparable<T>> {
    private T[] arr;
    private int nElems;

    // O(1) — just allocate array
    @SuppressWarnings("unchecked")
    public OrderedArray(int max) {
        arr = (T[]) new Object[max];
        nElems = 0;
    }

    // O(n) — binary search for position O(log n), but shifting is O(n)
    public void insert(T value) {
        if (nElems == arr.length) {
            resize(Math.max(arr.length * 2, 1)); // use Math.max to prevent unresizable zero-size arrays
        }
        int insertIndex = insertionPoint(value);
        for (int shiftIndex = nElems; shiftIndex > insertIndex; shiftIndex--) {
            arr[shiftIndex] = arr[shiftIndex - 1];
        }
        arr[insertIndex] = value;
        nElems++;
    }

    // O(log n) — binary search for correct insertion index
    private int insertionPoint(T value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (lowerBound <= upperBound) {
            int midIndex = (lowerBound + upperBound) / 2;
            if (arr[midIndex].compareTo(value) < 0) lowerBound = midIndex + 1; // negative means arr[mid] is smaller
            else upperBound = midIndex - 1;
        }
        return lowerBound;
    }

    // O(n) — binary search O(log n), shift left O(n)
    public boolean delete(T value) {
        int foundIndex = find(value);
        if (foundIndex == -1) return false;
        for (int shiftIndex = foundIndex; shiftIndex < nElems - 1; shiftIndex++) {
            arr[shiftIndex] = arr[shiftIndex + 1];
        }
        arr[--nElems] = null;
        return true;
    }

    // O(log n) — binary search works because array is always sorted
    public int find(T value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (lowerBound <= upperBound) {
            int midIndex = (lowerBound + upperBound) / 2;
            int compare = arr[midIndex].compareTo(value); // compareTo works on any type
            if (compare == 0) return midIndex; // 0 means equal
            else if (compare < 0) lowerBound = midIndex + 1; // negative means arr[mid] is smaller
            else upperBound = midIndex - 1;
        }
        return -1;
    }

    // O(1) — direct index access
    public T get(int index) {
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        return arr[index];
    }

    // O(1) — returns total capacity
    public int size() {
        return arr.length;
    }

    // O(1) — nElems always tracks non-null count
    public int count() {
        return nElems;
    }

    // O(n) — copy existing elements into new array, preserving order
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        T[] resizedArr = (T[]) new Object[newSize];
        int copyCount = Math.min(nElems, newSize);
        for (int shiftIndex = 0; shiftIndex < copyCount; shiftIndex++) {
            resizedArr[shiftIndex] = arr[shiftIndex];
        }
        arr = resizedArr;
        nElems = copyCount;
    }
}