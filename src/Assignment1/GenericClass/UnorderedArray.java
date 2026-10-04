package Assignment1.GenericClass;

public class UnorderedArray<T> {
    private T[] arr;
    private int nElems;

    // O(1) — just allocate array
    @SuppressWarnings("unchecked")
    public UnorderedArray(int max) {
        arr = (T[]) new Object[max];
        nElems = 0;
    }

    // O(1) amortized — append at end; O(n) only when resize triggers
    public void insert(T value) {
        if (nElems == arr.length) {
            resize(Math.max(arr.length * 2, 1)); // use Math.max to prevent unresizable zero-size arrays
        }
        arr[nElems++] = value;
    }

    // O(n) — linear search then shift left
    public boolean delete(T value) {
        int foundIndex = find(value);
        if (foundIndex == -1) return false;
        for (int shiftIndex = foundIndex; shiftIndex < nElems - 1; shiftIndex++) {
            arr[shiftIndex] = arr[shiftIndex + 1];
        }
        arr[--nElems] = null;
        return true;
    }

    // O(n) — must check every element (unsorted)
    public int find(T value) {
        for (int searchIndex = 0; searchIndex < nElems; searchIndex++) {
            if (arr[searchIndex] != null && arr[searchIndex] == value) return searchIndex;
        }
        return -1;
    }

    // O(1) — direct index access
    public T get(int index) {
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