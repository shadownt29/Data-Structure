package Assignment2.Iterators;

public class IteratorMain {
    public static void main(String[] args) {
        testSinglyIterator();
        testDoublyIterator();
    }

    static void testSinglyIterator() {
        System.out.println("===== LinkedListIterator =====");
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListIterator<Integer> it = list.getIterator();

        System.out.println("getCurrent on empty list: " + it.getCurrent());
        System.out.println("nextLink on empty list: " + it.nextLink());
        System.out.println("deleteCurrent on empty list: " + it.deleteCurrent());

        // insertAfter on an empty list adds the first element
        it.insertAfter(10);
        it.insertAfter(30);
        it.insertAfter(20);
        System.out.print("after insertAfter 10, 30, 20: ");
        list.display();

        it.insertBefore(5);
        System.out.print("after insertBefore(5) on first element: ");
        list.display();
        System.out.println("current is still: " + it.getCurrent());

        // walk through the list
        System.out.print("walking forward: ");
        it.reset();
        System.out.print(it.getCurrent());
        while (it.nextLink()) {
            System.out.print(" -> " + it.getCurrent());
        }
        System.out.println();
        System.out.println("atEnd: " + it.atEnd());

        // change a value in the middle
        it.reset();
        it.nextLink();
        it.nextLink();
        it.setCurrent(25);
        System.out.print("after setCurrent(25) on the 3rd element: ");
        list.display();

        it.insertBefore(15);
        System.out.print("after insertBefore(15): ");
        list.display();

        System.out.println("deleteCurrent: " + it.deleteCurrent() + ", now at " + it.getCurrent());
        System.out.print("list: ");
        list.display();

        // go to the last element and delete it
        while (it.nextLink()) { }
        System.out.println("at the last element: " + it.getCurrent());
        it.deleteCurrent();
        System.out.println("deleted last, iterator wrapped to: " + it.getCurrent());
        System.out.print("list: ");
        list.display();

        // makes sure the tail was fixed
        list.insertLast(99);
        System.out.print("insertLast(99) on the list: ");
        list.display();

        // delete everything with the iterator
        it.reset();
        while (it.getCurrent() != null) {
            it.deleteCurrent();
        }
        System.out.println("after deleting everything with the iterator: " + list);
        System.out.println();
    }

    static void testDoublyIterator() {
        System.out.println("===== DoublyLinkedListIterator =====");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        DoublyLinkedListIterator<String> it = list.getIterator();

        System.out.println("getCurrent on empty list: " + it.getCurrent());
        System.out.println("prevLink on empty list: " + it.prevLink());
        System.out.println("deleteCurrent on empty list: " + it.deleteCurrent());

        it.insertAfter("A");
        it.insertAfter("D");
        it.insertAfter("B");
        System.out.print("after insertAfter A, D, B: ");
        list.displayForward();

        it.nextLink();
        it.insertAfter("C");
        it.insertBefore("A2");
        System.out.print("after insertAfter(C) and insertBefore(A2) on B: ");
        list.displayForward();
        System.out.println("current is still: " + it.getCurrent());

        // forward
        System.out.print("walking forward: ");
        it.reset();
        System.out.print(it.getCurrent());
        while (it.nextLink()) {
            System.out.print(" -> " + it.getCurrent());
        }
        System.out.println();

        // backward
        System.out.print("walking backward: ");
        it.resetToEnd();
        System.out.print(it.getCurrent());
        while (it.prevLink()) {
            System.out.print(" -> " + it.getCurrent());
        }
        System.out.println();
        System.out.println("atStart: " + it.atStart());

        // delete in the middle
        it.reset();
        it.nextLink();
        it.nextLink();
        System.out.println("current: " + it.getCurrent());
        it.setCurrent("B2");
        System.out.print("after setCurrent(B2): ");
        list.displayForward();
        it.deleteCurrent();
        System.out.println("deleted B2, now at " + it.getCurrent());
        list.displayForward();
        list.displayBackward();

        // delete the last element
        it.resetToEnd();
        it.deleteCurrent();
        System.out.println("deleted last, now at " + it.getCurrent());
        list.displayForward();

        // delete the first element
        it.reset();
        it.deleteCurrent();
        System.out.println("deleted first, now at " + it.getCurrent());
        list.displayForward();
        list.displayBackward();

        // delete everything
        it.reset();
        while (it.getCurrent() != null) {
            it.deleteCurrent();
        }
        System.out.println("after deleting everything with the iterator: " + list);
    }
}
