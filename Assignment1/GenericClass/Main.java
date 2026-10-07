package Assignment1.GenericClass;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== UnorderedArray ===");
        UnorderedArray<String> ua = new UnorderedArray<>(3);
        ua.insert("a");
        ua.insert("b");
        ua.insert("c");
        ua.insert("d"); // triggers resize
        System.out.println();
        System.out.println("Size (capacity): " + ua.size());
        System.out.println("Count (elements): " + ua.count());
        System.out.println("Find 8: index " + ua.find("c"));
        System.out.println("Get index 1: " + ua.get(1));
        System.out.println("Delete 2: " + ua.delete("b"));
        System.out.println("Delete 99: " + ua.delete("e"));
        System.out.println("Count after delete: " + ua.count());

        System.out.println("\n=== OrderedArray ===");
        OrderedArray<Integer> oa = new OrderedArray<>(3);
        oa.insert(5);
        oa.insert(2);
        oa.insert(8);
        oa.insert(1); // triggers resize
        System.out.println("Size (capacity): " + oa.size());
        System.out.println("Count (elements): " + oa.count());
        System.out.println("Find 8: index " + oa.find(8));
        System.out.println("Get index 0 (should be 1): " + oa.get(0));
        System.out.println("Delete 5: " + oa.delete(5));
        System.out.println("Delete 99: " + oa.delete(99));
        System.out.println("Count after delete: " + oa.count());

        // test IndexOutOfBoundsException
        try {
            oa.get(999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}