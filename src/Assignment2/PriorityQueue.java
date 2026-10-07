package Assignment2;

public class PriorityQueue<T> {
    private T[] items;
    private int[] priorities;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int arraySize) {
        items = (T[]) new Object[arraySize > 0 ? arraySize : 1];
        priorities = new int[arraySize > 0 ? arraySize : 1];
        size = 0;
    }

    // O(n) — shifts elements right to insert in sorted position (descending priorityValue)
    // index 0 = lowest priority (rear), index size-1 = highest priority (smallest priorityValue = front)
    public void insert(T newItem, int priorityValue) {
        if (size == items.length) {
            resize();
        }
        int i = size - 1;
        while (i >= 0 && priorities[i] < priorityValue) {
            items[i + 1] = items[i];
            priorities[i + 1] = priorities[i];
            i--;
        }
        items[i + 1] = newItem;
        priorities[i + 1] = priorityValue;
        size++;
    }

    // O(n) — doubles capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newItems = (T[]) new Object[items.length * 2]; // doubling the size is more efficient than +1 increment [O(n) vs. O(n²)]
        int[] newPriorities = new int[priorities.length * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
            newPriorities[i] = priorities[i];
        }
        items = newItems;
        priorities = newPriorities;
    }

    // O(1) — removes highest priority item from front; null if empty
    public T remove() {
        if (size == 0) return null;
        T item = items[size - 1];
        items[size - 1] = null;
        size--;
        return item;
    }

    // O(1) — returns highest priority item (front); null if empty
    public T peekFront() {
        if (size == 0) return null;
        return items[size - 1];
    }

    // O(1) — returns lowest priority item (rear); null if empty
    public T peekRear() {
        if (size == 0) return null;
        return items[0];
    }

    // O(n) — builds string from highest to lowest priority
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]).append("(p=").append(priorities[i]).append(")");
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) — prints the priority queue
    public void display() {
        System.out.println(toString());
    }
}
