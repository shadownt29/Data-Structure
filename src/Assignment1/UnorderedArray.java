package Assignment1;

public class UnorderedArray {
    private Integer[] arr;
    private int nElems; // tracks non-null element count

    // O(1) — just allocate array
    public UnorderedArray(int max) {
        arr = new Integer[max];
        nElems = 0;
    }

    // O(1) amortized — append at end; O(n) only when resize triggers
    public void insert(int x) {
        if (nElems == arr.length) {
            resize(arr.length * 2);
        }
        arr[nElems++] = x;
    }

    // O(n) — linear search then shift left
    public boolean delete(int x) {
        int idx = find(x);
        if (idx == -1) return false;
        for (int k = idx; k < nElems - 1; k++) {
            arr[k] = arr[k + 1];
        }
        arr[--nElems] = null;
        return true;
    }

    // O(n) — must check every element (unsorted)
    public int find(int x) {
        for (int j = 0; j < nElems; j++) {
            if (arr[j] != null && arr[j] == x) return j;
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
        Integer[] newArr = new Integer[newSize];
        int toCopy = Math.min(nElems, newSize);
        for (int i = 0; i < toCopy; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        nElems = toCopy;
    }
}