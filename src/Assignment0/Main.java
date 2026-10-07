package Assignment0;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);
        int choice, x;

        while (true) {
            System.out.println("\nTotal: " + calc.getTotal());
            System.out.println("1. Add");
            System.out.println("2. Deduct");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulo");
            System.out.println("6. Reset");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            if (choice == 0) break;

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter number: ");
                x = scanner.nextInt();
            } else x = 0;

            switch (choice) {
                case 1 -> calc.add(x);
                case 2 -> calc.deduct(x);
                case 3 -> calc.multiply(x);
                case 4 -> calc.divide(x);
                case 5 -> calc.modulo(x);
                case 6 -> calc.reset();
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Final total: " + calc.getTotal());
        scanner.close();
    }
}
