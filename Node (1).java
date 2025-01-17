import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printMiddleNode() {
        Node slow = head;
        Node fast = head;

        if (head != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Middle node: " + slow.data);
        }
    }

    public SinglyLinkedList reverse() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;

        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            current = current.next;
        }

        return reversedList;
    }

    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node p1 = list1.head, p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                mergedList.append(p1.data);
                p1 = p1.next;
            } else {
                mergedList.append(p2.data);
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            mergedList.append(p1.data);
            p1 = p1.next;
        }

        while (p2 != null) {
            mergedList.append(p2.data);
            p2 = p2.next;
        }

        return mergedList;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void deleteList() {
        head = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Enter numbers to add to the linked list (enter -1 to stop):");

        while (true) {
            int data = scanner.nextInt();
            if (data == -1) break;
            list.append(data);
        }

        System.out.println("Original Linked List:");
        list.display();

        System.out.println("Length of Linked List: " + list.length());

        list.printMiddleNode();

        SinglyLinkedList reversedList = list.reverse();
        System.out.println("Reversed Linked List:");
        reversedList.display();

        System.out.println("Removing duplicates from sorted Linked List:");

        SinglyLinkedList secondList = new SinglyLinkedList();
        secondList.append(1);
        secondList.append(3);
        secondList.append(5);

        System.out.println("Second Sorted Linked List:");
        secondList.display();

        SinglyLinkedList mergedResult = SinglyLinkedList.merge(list, secondList);
        System.out.println("Merged Sorted Linked List:");
        mergedResult.display();

        list.deleteList();
        System.out.println("Deleted original Linked List.");
        System.out.println("Original Linked List after deletion:");
        list.display();

        scanner.close();
    }
}