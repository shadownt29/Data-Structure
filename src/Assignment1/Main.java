package Assignment1;



public class Main {
    public static void main(String[] args) {

        System.out.println("=== UnorderedArray ===");
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(5);
        ua.insert(2);
        ua.insert(8);
        ua.insert(1); // triggers resize
        System.out.println("Size (capacity): " + ua.size());
        System.out.println("Count (elements): " + ua.count());
        System.out.println("Find 8: index " + ua.find(8));
        System.out.println("Get index 1: " + ua.get(1));
        System.out.println("Delete 2: " + ua.delete(2));
        System.out.println("Delete 99: " + ua.delete(99));
        System.out.println("Count after delete: " + ua.count());

//        System.out.println("\n=== OrderedArray ===");
//        OrderedArray oa = new OrderedArray(3);
//        oa.insert(5);
//        oa.insert(2);
//        oa.insert(8);
//        oa.insert(1); // triggers resize
//        System.out.println("Size (capacity): " + oa.size());
//        System.out.println("Count (elements): " + oa.count());
//        System.out.println("Find 8: index " + oa.find(8));
//        System.out.println("Get index 0 (should be 1): " + oa.get(0));
//        System.out.println("Delete 5: " + oa.delete(5));
//        System.out.println("Delete 99: " + oa.delete(99));
//        System.out.println("Count after delete: " + oa.count());

        // test IndexOutOfBoundsException
        try {
            oa.get(999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}