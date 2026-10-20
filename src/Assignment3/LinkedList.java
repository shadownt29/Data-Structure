package Assignment3;

public class LinkedList<T> {
    private Link<T> head;
    private Link<T> tail;

    // O(1) - creates an empty list
    public LinkedList() {
        head = null;
        tail = null;
    }

    // O(1) - adds to the front
    public void insertFirst(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            tail = newLink;
        }
        newLink.next = head;
        head = newLink;
    }

    // O(1) - adds to the end using the tail pointer
    public void insertLast(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = newLink;
        } else {
            tail.next = newLink;
        }
        tail = newLink;
    }

    // O(n) - walks to the link before the index; index <= 0 inserts first, index >= size inserts last
    public void insertAt(int index, T newItem) {
        if (index <= 0 || isEmpty()) {
            insertFirst(newItem);
            return;
        }
        Link<T> current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current == tail) {
            insertLast(newItem);
            return;
        }
        Link<T> newLink = new Link<>(newItem);
        newLink.next = current.next;
        current.next = newLink;
    }

    // O(1) - removes the first link; false if empty
    public boolean deleteFirst() {
        if (isEmpty()) return false;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        return true;
    }

    // O(n) - singly linked, so we must walk to the second-to-last link; false if empty
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = null;
            tail = null;
            return true;
        }
        Link<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        return true;
    }

    // O(n) - walks to the link before the index; false if index is invalid
    public boolean deleteAt(int index) {
        if (isEmpty() || index < 0) return false;
        if (index == 0) return deleteFirst();
        Link<T> current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) return false;
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
        return true;
    }

    // O(n) - removes the first link matching the key; false if not found
    public boolean deleteKey(T key) {
        if (isEmpty()) return false;
        if (head.data.equals(key)) return deleteFirst();
        Link<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(key)) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // O(n) - returns the index of the first match, -1 if not found
    public int find(T key) {
        Link<T> current = head;
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

    // O(1) - returns the first item without removing it; null if empty
    public T peekFirst() {
        if (isEmpty()) return null;
        return head.data;
    }

    // O(1) - returns the last item without removing it; null if empty
    public T peekLast() {
        if (isEmpty()) return null;
        return tail.data;
    }

    // O(n) - builds string from first to last
    @Override // replace the existing Java build-in toString() in Object class
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Link<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // O(n) - prints the list
    public void display() {
        System.out.println(toString());
    }
}
