package Assignment2.Iterators;

public class DoublyLinkedListIterator<T> {
    private final DoublyLinkedList<T> list;
    private DoublyLink<T> current;

    // O(1) - creates an iterator pointing at the first element of the list
    public DoublyLinkedListIterator(DoublyLinkedList<T> list) {
        this.list = list;
        reset();
    }

    // O(1) - goes back to the first element
    public void reset() {
        current = list.getFirst();
    }

    // O(1) - goes to the last element, useful for going backward
    public void resetToEnd() {
        current = list.getLast();
    }

    // O(1) - true if the list is empty or the iterator is on the last element
    public boolean atEnd() {
        return current == null || current.next == null;
    }

    // O(1) - true if the list is empty or the iterator is on the first element
    public boolean atStart() {
        return current == null || current.previous == null;
    }

    // O(1) - moves to the next element; false if already at the end
    public boolean nextLink() {
        if (atEnd()) return false;
        current = current.next;
        return true;
    }

    // O(1) - moves to the previous element; false if already at the start
    public boolean prevLink() {
        if (atStart()) return false;
        current = current.previous;
        return true;
    }

    // O(1) - returns the data of the current element; null if the list is empty
    public T getCurrent() {
        if (current == null) return null;
        return current.data;
    }

    // O(1) - replaces the data of the current element; false if the list is empty
    public boolean setCurrent(T newItem) {
        if (current == null) return false;
        current.data = newItem;
        return true;
    }

    // O(1) - inserts after the current element, the iterator stays where it is
    public void insertAfter(T newItem) {
        if (list.isEmpty()) {
            list.insertFirst(newItem);
            reset();
            return;
        }
        if (current == list.getLast()) {
            list.insertLast(newItem);
            return;
        }
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        newLink.next = current.next;
        newLink.previous = current;
        current.next.previous = newLink;
        current.next = newLink;
    }

    // O(1) - inserts before the current element, the iterator stays on the same element
    public void insertBefore(T newItem) {
        if (list.isEmpty()) {
            list.insertFirst(newItem);
            reset();
            return;
        }
        if (current == list.getFirst()) {
            list.insertFirst(newItem);
            return;
        }
        DoublyLink<T> newLink = new DoublyLink<>(newItem);
        newLink.next = current;
        newLink.previous = current.previous;
        current.previous.next = newLink;
        current.previous = newLink;
    }

    // O(1) - deletes the current element and moves to the next one; if there is no next, moves to the previous
    public boolean deleteCurrent() {
        if (current == null) return false;
        if (current == list.getFirst()) {
            list.deleteFirst();
            current = list.getFirst();
            return true;
        }
        if (current == list.getLast()) {
            list.deleteLast();
            current = list.getLast();
            return true;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current = current.next;
        return true;
    }
}
