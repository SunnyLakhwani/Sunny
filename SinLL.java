import org.w3c.dom.Node;
public class SinLL {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(String data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }
    public void addLast(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList(){
        if (head == null){
            System.out.println("Linked List is Empty");
            return;
        }
        Node currNode = head;
        while (currNode.next != null){
            System.out.println(currNode.data + "->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }
    public void deleteFirst(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast(){
        if (head == null){
            System.out.println("List Is Empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node SecondLast = head;
        Node LastNode = head.next;
        while(LastNode.next != null){
            LastNode = LastNode.next;
            SecondLast = SecondLast.next;
        }
        SecondLast.next = null;
    }

}


