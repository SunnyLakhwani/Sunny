class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

 class LinkedList {
    private ListNode head;

    // Add a new node at the end
    public void add(int value) {
        ListNode newNode = new ListNode(value);
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

    // Count occurrences of a given integer
    public int countOccurrences(int target) {
        int count = 0;
        for (ListNode current = head; current != null; current = current.next) {
            if (current.value == target)
                 count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Adding elements
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(2);

        int targetValue = 2;
        System.out.println("The number " + targetValue + " occurs " + linkedList.countOccurrences(targetValue) + " times.");
        // Output: The number 2 occurs 3 times.
    }
}