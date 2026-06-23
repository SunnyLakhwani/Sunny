class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    ListNode head;

    // Method to reverse the linked list iteratively
    public void reverseList() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current;      // Move prev and current one step forward
            current = next;
        }
        head = prev; // Update head to the new front of the list
    }

    // Method to print the linked list
    public void printList() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// Driver code
 class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(5);
        list.head.next = new ListNode(8);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(9);
        list.head.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        list.printList();

        list.reverseList(); // Reverse the linked list

        System.out.println("Reversed Linked List:");
        list.printList();
    }
}