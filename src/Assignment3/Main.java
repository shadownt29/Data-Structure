package Assignment3;

public class Main {
    public static void main(String[] args) {
        testLinkedList();
        testDoublyLinkedList();
        testStack();
        testQueue();
    }

    static void testLinkedList() {
        System.out.println("===== LinkedList =====");
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("isEmpty on new list: " + list.isEmpty());
        System.out.println("deleteFirst on empty: " + list.deleteFirst());
        System.out.println("deleteLast on empty: " + list.deleteLast());

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);
        list.insertLast(40);
        System.out.print("after insertFirst/insertLast: ");
        list.display();

        list.insertAt(2, 25);
        list.insertAt(0, 5);
        list.insertAt(100, 50);
        System.out.print("after insertAt(2,25), (0,5), (100,50): ");
        list.display();

        System.out.println("find(25): " + list.find(25));
        System.out.println("find(999): " + list.find(999));

        System.out.println("deleteFirst: " + list.deleteFirst());
        System.out.println("deleteLast: " + list.deleteLast());
        System.out.print("after deleteFirst and deleteLast: ");
        list.display();

        System.out.println("deleteAt(2): " + list.deleteAt(2));
        System.out.println("deleteAt(50): " + list.deleteAt(50));
        System.out.println("deleteAt(-1): " + list.deleteAt(-1));
        System.out.print("after deleteAt: ");
        list.display();

        System.out.println("deleteKey(30): " + list.deleteKey(30));
        System.out.println("deleteKey(999): " + list.deleteKey(999));
        System.out.println("toString: " + list.toString());

        // checks that the tail is still right after the deletes
        list.insertLast(60);
        System.out.print("insertLast(60) after deletes: ");
        list.display();

        while (!list.isEmpty()) {
            list.deleteFirst();
        }
        System.out.println("after deleting everything: " + list + ", isEmpty: " + list.isEmpty());
        list.insertLast(1);
        System.out.println("insertLast on emptied list: " + list);
        System.out.println();
    }

    static void testDoublyLinkedList() {
        System.out.println("===== DoublyLinkedList =====");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println("isEmpty on new list: " + list.isEmpty());
        System.out.println("deleteFirst on empty: " + list.deleteFirst());
        System.out.println("deleteLast on empty: " + list.deleteLast());

        list.insertFirst("B");
        list.insertFirst("A");
        list.insertLast("D");
        list.insertLast("E");
        list.insertAt(2, "C");
        list.insertAt(0, "Z");
        list.insertAt(100, "F");
        System.out.println("after inserts:");
        list.displayForward();
        list.displayBackward();

        System.out.println("find(C): " + list.find("C"));
        System.out.println("find(X): " + list.find("X"));

        System.out.println("deleteFirst: " + list.deleteFirst());
        System.out.println("deleteLast: " + list.deleteLast());
        System.out.println("deleteAt(2): " + list.deleteAt(2));
        System.out.println("deleteAt(50): " + list.deleteAt(50));
        System.out.println("deleteKey(D): " + list.deleteKey("D"));
        System.out.println("deleteKey(X): " + list.deleteKey("X"));
        System.out.println("after deletes:");
        list.displayForward();
        list.displayBackward();
        System.out.println("toString: " + list.toString());

        while (!list.isEmpty()) {
            list.deleteLast();
        }
        System.out.println("after deleting everything: " + list + ", isEmpty: " + list.isEmpty());
        list.displayBackward();
        list.insertFirst("again");
        System.out.println("insertFirst on emptied list: " + list);
        System.out.println();
    }

    static void testStack() {
        System.out.println("===== Stack =====");
        Stack<Integer> stack = new Stack<>();
        System.out.println("pop on empty: " + stack.pop());
        System.out.println("peek on empty: " + stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print("after push 1, 2, 3 (top first): ");
        stack.display();
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.print("remaining: ");
        stack.display();
        System.out.println();
    }

    static void testQueue() {
        System.out.println("===== Queue =====");
        Queue<Integer> queue = new Queue<>();
        System.out.println("remove on empty: " + queue.remove());
        System.out.println("peekFront on empty: " + queue.peekFront());
        System.out.println("peekRear on empty: " + queue.peekRear());
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        System.out.print("after insert 1, 2, 3 (front first): ");
        queue.display();
        System.out.println("peekFront: " + queue.peekFront());
        System.out.println("peekRear: " + queue.peekRear());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.print("remaining: ");
        queue.display();
        queue.insert(4);
        System.out.println("insert 4, peekRear: " + queue.peekRear());
    }
}
