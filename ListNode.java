class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode head;

    // Method to add a new node at the end of the list
    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to check if sublist is present in the main list
    public boolean isSublist(MyLinkedList sublist) {
        if (sublist.head == null) return true; // Empty sublist is always found
        if (this.head == null) return false;   // Non-empty sublist cannot be found in an empty list

        ListNode mainCurrent = this.head;

        while (mainCurrent != null) {
            if (isMatch(mainCurrent, sublist.head)) {
                return true; // Sublist found
            }
            mainCurrent = mainCurrent.next; // Move to the next node in main list
        }

        return false; // Sublist not found
    }

    // Helper method to check if two lists match starting from two nodes
    private boolean isMatch(ListNode mainNode, ListNode subNode) {
        while (mainNode != null && subNode != null && mainNode.data == subNode.data) {
            mainNode = mainNode.next;
            subNode = subNode.next;
        }
        return subNode == null; // If we reached the end of the sublist, they match
    }
    class Driver {
    public static void main(String[] args) {
        // Creating the main linked list
        MyLinkedList mainList = new MyLinkedList();
        mainList.add(10);
        mainList.add(15);
        mainList.add(23);
        mainList.add(30);
        mainList.add(41);

        System.out.println("Main Linked List:");
        mainList.printList();

        // Creating the sublinked list
        MyLinkedList subList = new MyLinkedList();
        subList.add(23);
        subList.add(30);

        System.out.println("Sub Linked List:");
        subList.printList();

        // Checking if the sublist exists in the main list
        boolean exists = mainList.isSublist(subList);

        if (exists) {
            System.out.println("Sublist found in the main list.");
        } else {
            System.out.println("Sublist not found in the main list.");
        }
    }
}
}