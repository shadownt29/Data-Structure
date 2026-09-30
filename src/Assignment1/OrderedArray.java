package Assignment1;

public class OrderedArray {
    private Integer[] arr;
    private int nElems;

    // O(1) — just allocate array
    public OrderedArray(int max) {
        arr = new Integer[max];
        nElems = 0;
    }

    // O(n) — binary search for position O(log n), but shifting is O(n)
    public void insert(int value) {
        if (nElems == arr.length) {
            resize(Math.max(arr.length * 2, 1)); // prevent unresizable zero-size arrays
        }
        int insertIndex = insertionPoint(value);
        for (int shiftIndex = nElems; shiftIndex > insertIndex; shiftIndex--) {
            arr[shiftIndex] = arr[shiftIndex - 1];
        }
        arr[insertIndex] = value;
        nElems++;
    }

    // O(log n) — binary search for correct insertion index
    private int insertionPoint(int value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (lowerBound <= upperBound) {
            int midIndex = (lowerBound + upperBound) / 2;
            if (arr[midIndex] < value) lowerBound = midIndex + 1;
            else upperBound = midIndex - 1;
        }
        return lowerBound;
    }

    // O(n) — binary search O(log n), shift left O(n)
    public boolean delete(int value) {
        int foundIndex = find(value);
        if (foundIndex == -1) return false;
        for (int shiftIndex = foundIndex; shiftIndex < nElems - 1; shiftIndex++) {
            arr[shiftIndex] = arr[shiftIndex + 1];
        }
        arr[--nElems] = null;
        return true;
    }

    // O(log n) — binary search works because array is always sorted
    public int find(int value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        while (lowerBound <= upperBound) {
            int midIndex = (lowerBound + upperBound) / 2;
            if (arr[midIndex] == value) return midIndex;
            else if (arr[midIndex] < value) lowerBound = midIndex + 1;
            else upperBound = midIndex - 1;
        }
        return -1;
    }

    // O(1) — direct index access
    public Integer get(int index) {
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
    public void resize(int newSize) {
        Integer[] resizedArr = new Integer[newSize];
        int copyCount = Math.min(nElems, newSize);
        for (int shiftIndex = 0; shiftIndex < copyCount; shiftIndex++) {
            resizedArr[shiftIndex] = arr[shiftIndex];
        }
        arr = resizedArr;
        nElems = copyCount;
    }
}