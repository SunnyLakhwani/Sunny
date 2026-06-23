public class LL {
    Node head;
    private int size;

    LL(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
  // add - First, Last
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Print

    public void PrintList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
            Node currNode = head;
            while (currNode != null) {
                System.out.println(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("Null");
        }

        // delete first
    public void deleteFirst(){
        if (head == null){
            System.out.println("The List Is Empty");
            return;
        }
        size--;
        head = head.next;
    }

    //delete last

    public void deleteLast(){
        if (head == null){
            System.out.println("The list is empty");
            return;
        }
        size--;

        if (head.next == null){
            head = null;
            return;
        }

        Node secondlast = head;
        Node lastNode = head.next; // head.next = null -> lastNode = null
        while (lastNode.next != null){ // null.next
            lastNode = lastNode.next;
            secondlast = secondlast.next;
        }
        secondlast.next = null;
    }
    // Size
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.PrintList();

        list.addLast("List");
        list.PrintList();

        list.addFirst("This ");
        list.PrintList();

        list.deleteFirst();
        list.PrintList();

        list.deleteLast();
        list.PrintList();

        System.out.println(list.getSize());
        list.addFirst("this");
        System.out.println(list.getSize());



    }
}
