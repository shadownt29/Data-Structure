package Assignment3;

public class Queue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int count;

    @SuppressWarnings("unchecked")
    public Queue(int arraySize) {
        array = (T[]) new Object[arraySize > 0 ? arraySize : 1];
        front = 0;
        rear = -1;
        count = 0;
    }

    // O(1) — O(n) only when resize occurs
    public void insert(T newItem) {
        if (count == array.length) {
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = newItem;
        count++;
    }

    // O(n) — doubles capacity and realigns elements from circular layout
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2]; // doubling arrSize is more efficient than +1 increment [O(n) vs. O(n²)]
        for (int i = 0; i < count; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        front = 0;
        rear = count - 1;
        array = newArray;
    }

    // O(1) — removes and returns front element; null if empty
    public T remove() {
        if (count == 0) return null;
        T item = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        count--;
        return item;
    }

    // O(1) — returns front element without removing; null if empty
    public T peekFront() {
        if (count == 0) return null;
        return array[front];
    }

    // O(1) — returns rear element without removing; null if empty
    public T peekRear() {
        if (count == 0) return null;
        return array[rear];
    }

    // O(n) — builds string from front to rear
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        if (count == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(array[(front + i) % array.length]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) — prints the queue
    public void display() {
        System.out.println(toString());
    }
}
