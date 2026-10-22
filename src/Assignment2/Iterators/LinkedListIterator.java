package Assignment2.Iterators;

public class LinkedListIterator<T> {
    private final LinkedList<T> list;
    private Link<T> current;
    private Link<T> previous; // singly linked, so the iterator has to remember the link before current

    // O(1) - creates an iterator pointing at the first element of the list
    public LinkedListIterator(LinkedList<T> list) {
        this.list = list;
        reset();
    }

    // O(1) - goes back to the first element
    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    // O(1) - true if the list is empty or the iterator is on the last element
    public boolean atEnd() {
        return current == null || current.next == null;
    }

    // O(1) - moves to the next element; false if already at the end
    public boolean nextLink() {
        if (atEnd()) return false;
        previous = current;
        current = current.next;
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
        Link<T> newLink = new Link<>(newItem);
        newLink.next = current.next;
        current.next = newLink;
    }

    // O(1) - inserts before the current element, the iterator stays on the same element
    public void insertBefore(T newItem) {
        if (list.isEmpty()) {
            list.insertFirst(newItem);
            reset();
            return;
        }
        if (previous == null) {
            list.insertFirst(newItem);
            previous = list.getFirst();
            return;
        }
        Link<T> newLink = new Link<>(newItem);
        newLink.next = current;
        previous.next = newLink;
        previous = newLink;
    }

    // O(1) - deletes the current element and moves to the next one; if there is no next, goes back to the first
    public boolean deleteCurrent() {
        if (current == null) return false;
        if (previous == null) {
            list.deleteFirst();
            current = list.getFirst();
            return true;
        }
        if (current == list.getLast()) {
            list.setLast(previous);
        }
        previous.next = current.next;
        current = current.next;
        if (current == null) {
            reset();
        }
        return true;
    }
}
