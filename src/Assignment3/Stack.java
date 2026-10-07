package Assignment3;

public class Stack<T> {
    private T[] array;
    private int top;

    @SuppressWarnings("unchecked") // Tell compiler to ignore type-safety warnings
    public Stack(int arraySize) {
        array = (T[]) new Object[arraySize > 0 ? arraySize : 1];
        top = -1;
    }

    // O(1) — O(n) only when resize occurs
    public void push(T newItem) {
        if (top == array.length - 1) {
            resize();
        }
        array[++top] = newItem;
    }

    // O(n) — doubles array capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2]; // doubling arrSize is more efficient than +1 increment [O(n) vs. O(n²)]
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // O(1) — removes and returns top element; null if empty
    public T pop() {
        if (top == -1) return null;
        T item = array[top];
        array[top--] = null;
        return item;
    }

    // O(1) — returns top element without removing; null if empty
    public T peek() {
        if (top == -1) return null;
        return array[top];
    }

    // O(n) — builds string from top to bottom
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        if (top == -1) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) — prints the stack
    public void display() {
        System.out.println(toString());
    }
}
