import java.util.Scanner;

class SinglyNode {
    String dish;
    double price;
    SinglyNode next;

    public SinglyNode(String dish, double price) {
        this.dish = dish;
        this.price = price;
        this.next = null;
    }
}

class SinglyLinkedList {
    private SinglyNode head;

    public void addDish(String dish, double price) {
        SinglyNode newNode = new SinglyNode(dish, price);
        if (head == null) {
            head = newNode;
        } else {
            SinglyNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayMenu() {
        SinglyNode current = head;
        while (current != null) {
            System.out.printf("%s - $%.2f%n", current.dish, current.price);
            current = current.next;
        }
    }

    public double getPrice(int index) {
        SinglyNode current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.price;
            }
            count++;
            current = current.next;
        }
        return 0; // Return 0 if index is out of bounds
    }

    public int getSize() {
        SinglyNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

class RestaurantMenuSinglyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList breakfastMenu = new SinglyLinkedList();
        breakfastMenu.addDish("Pancakes", 5.99);
        breakfastMenu.addDish("Omelette", 6.49);
        breakfastMenu.addDish("French Toast", 4.99);
        breakfastMenu.addDish("Fruit Salad", 3.99);

        SinglyLinkedList lunchMenu = new SinglyLinkedList();
        lunchMenu.addDish("Grilled Chicken Sandwich", 8.99);
        lunchMenu.addDish("Caesar Salad", 7.49);
        lunchMenu.addDish("Pasta Primavera", 9.99);
        lunchMenu.addDish("Veggie Burger", 8.49);

        SinglyLinkedList dinnerMenu = new SinglyLinkedList();
        dinnerMenu.addDish("Steak", 19.99);
        dinnerMenu.addDish("Salmon", 17.99);
        dinnerMenu.addDish("Vegetable Stir Fry", 14.99);
        dinnerMenu.addDish("Chicken Alfredo", 15.99);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Breakfast");
            System.out.println("2. Lunch");
            System.out.println("3. Dinner");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            SinglyLinkedList selectedMenu = null;

            switch (choice) {
                case 1:
                    selectedMenu = breakfastMenu;
                    break;
                case 2:
                    selectedMenu = lunchMenu;
                    break;
                case 3:
                    selectedMenu = dinnerMenu;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue; // Skip to the next iteration of the loop
            }

            System.out.println("\nMenu Items:");
            selectedMenu.displayMenu();

            System.out.print("\nSelect item numbers to order (comma-separated): ");
            scanner.nextLine(); // Consume newline
            String[] itemsOrdered = scanner.nextLine().split(",");

            double totalBill = 0;

            for (String item : itemsOrdered) {
                int index = Integer.parseInt(item.trim()) - 1; // Convert to zero-based index
                if (index >= 0 && index < selectedMenu.getSize()) {
                    totalBill += selectedMenu.getPrice(index);
                } else {
                    System.out.println("Invalid item number: " + (index + 1));
                }
            }

            System.out.printf("Total Bill: $%.2f%n", totalBill);
        }

        scanner.close();
    }
}
