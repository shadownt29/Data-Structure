package Assignment3;

public class DoublyLinkedList<T> {
    private DoublyLink<T> head;
    private DoublyLink<T> tail;

    // O(1) - creates an empty list
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // O(1) - adds to the front
    public void insertFirst(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        if (isEmpty()) {
            tail = newLink;
        } else {
            head.previous = newLink;
        }
        newLink.next = head;
        head = newLink;
    }

    // O(1) - adds to the end using the tail pointer
    public void insertLast(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        if (isEmpty()) {
            head = newLink;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
    }

    // O(n) - traverses to the link before the index; index <= 0 inserts first, index >= size inserts last
    public void insertAt(int index, T newItem) {
        if (index <= 0 || isEmpty()) {
            insertFirst(newItem);
            return;
        }
        DoublyLink<T> current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current == tail) {
            insertLast(newItem);
            return;
        }
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        newLink.next = current.next;
        newLink.previous = current;
        current.next.previous = newLink;
        current.next = newLink;
    }

    // O(1) - removes the first link; false if empty
    public boolean deleteFirst() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        return true;
    }

    // O(1) - the previous pointer gives direct access to the second-to-last link; false if empty
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return true;
    }

    // O(n) - traverses to the index; false if index is invalid
    public boolean deleteAt(int index) {
        if (isEmpty() || index < 0) return false;
        if (index == 0) return deleteFirst();
        DoublyLink<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) return false;
        if (current == tail) return deleteLast();
        current.previous.next = current.next;
        current.next.previous = current.previous;
        return true;
    }

    // O(n) - removes the first link matching the key; false if not found
    public boolean deleteKey(T key) {
        DoublyLink<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                if (current == head) return deleteFirst();
                if (current == tail) return deleteLast();
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // O(n) - returns the index of the first match, -1 if not found
    public int find(T key) {
        DoublyLink<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // O(1) - true if the list has no links
    public boolean isEmpty() {
        return head == null;
    }

    // O(n) - builds string from first to last
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) - prints the list from head to tail
    public void displayForward() {
        System.out.println(toString());
    }

    // O(n) - prints the list from tail to head
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.previous != null) sb.append(", ");
            current = current.previous;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
