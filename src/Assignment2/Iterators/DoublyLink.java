package Assignment2.Iterators;

public class DoublyLink<T> {
    public T data;
    public DoublyLink<T> next;
    public DoublyLink<T> previous;

    // O(1) - creates a link holding the given data
    public DoublyLink(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
