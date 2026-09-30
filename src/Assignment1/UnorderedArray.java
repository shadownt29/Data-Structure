package Assignment1;

public class UnorderedArray {
    private Integer[] arr;
    private int nElems;

    // O(1) — just allocate array
    public UnorderedArray(int max) {
        arr = new Integer[max];
        nElems = 0;
    }

    // O(1) amortized — append at end; O(n) only when resize triggers
    public void insert(int value) {
        if (nElems == arr.length) {
            resize(Math.max(arr.length * 2, 1)); // use Math.max to prevent unresizable zero-size arrays
        }
        arr[nElems++] = value;
    }

    // O(n) — linear search then shift left
    public boolean delete(int value) {
        int foundIndex = find(value);
        if (foundIndex == -1) return false;
        for (int shiftIndex = foundIndex; shiftIndex < nElems - 1; shiftIndex++) {
            arr[shiftIndex] = arr[shiftIndex + 1];
        }
        arr[--nElems] = null;
        return true;
    }

    // O(n) — must check every element (unsorted)
    public int find(int value) {
        for (int searchIndex = 0; searchIndex < nElems; searchIndex++) {
            if (arr[searchIndex] != null && arr[searchIndex] == value) return searchIndex;
        }
        return -1;
    }

    // O(1) — direct index access
    public Integer get(int index) {
        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        return arr[index];
    }

    // O(1) — returns total capacity of arr[]
    public int size() {
        return arr.length;
    }

    // O(1) — nElems always tracks non-null count
    public int count() {
        return nElems;
    }

    // O(n) — copy existing elements into new array
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