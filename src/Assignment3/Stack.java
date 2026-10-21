package Assignment3;

public class Stack<T> {
    private final LinkedList<T> list;

    // O(1) - creates an empty stack backed by a linked list
    public Stack() {
        list = new LinkedList<>();
    }

    // O(1) - insertFirst is O(1) and there is no resize anymore
    public void push(T newItem) {
        list.insertFirst(newItem);
    }

    // O(1) - removes and returns top element; null if empty
    public T pop() {
        T item = list.peekFirst();
        list.deleteFirst();
        return item;
    }

    // O(1) - returns top element without removing; null if empty
    public T peek() {
        return list.peekFirst();
    }

    // O(n) - builds string from top to bottom
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        return list.toString();
    }

    // O(n) - prints the stack
    public void display() {
        System.out.println(toString());
    }
}
