package Assignment3;

public class Queue<T> {
    private final LinkedList<T> list;

    // O(1) - creates an empty queue backed by a linked list
    public Queue() {
        list = new LinkedList<>();
    }

    // O(1) - insertLast is O(1) because the list has a tail pointer
    public void insert(T newItem) {
        list.insertLast(newItem);
    }

    // O(1) - removes and returns front element; null if empty
    public T remove() {
        T item = list.peekFirst();
        list.deleteFirst();
        return item;
    }

    // O(1) - returns front element without removing; null if empty
    public T peekFront() {
        return list.peekFirst();
    }

    // O(1) - returns rear element without removing; null if empty
    public T peekRear() {
        return list.peekLast();
    }

    // O(n) - builds string from front to rear
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        return list.toString();
    }

    // O(n) - prints the queue
    public void display() {
        System.out.println(toString());
    }
}
