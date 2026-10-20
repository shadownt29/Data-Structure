package Assignment3;

public class Link<T> {
    public T data;
    public Link<T> next;

    // O(1) - creates a link holding the given data
    public Link(T data) {
        this.data = data;
        this.next = null;
    }
}
