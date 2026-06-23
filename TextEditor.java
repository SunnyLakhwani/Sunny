class Node {
    char data;
    Node prev;
    Node next;

    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(char c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void delete() {
        if (tail != null) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = null;
                tail = null;
            }
        }
    }

    public void modify(int position, char newChar) {
        Node current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current != null) {
            current.data = newChar;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

public class TextEditor {
    private DoublyLinkedList text;

    public TextEditor() {
        text = new DoublyLinkedList();
    }

    public void insertText(String str) {
        for (char c : str.toCharArray()) {
            text.insert(c);
        }
    }

    public void deleteText() {
        text.delete();
    }

    public void modifyText(int position, char newChar) {
        text.modify(position, newChar);
    }

    public void displayText() {
        text.display();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insertText("Hello world");
        System.out.print("Initial Text: ");
        editor.displayText();

        editor.modifyText(6, 'W');
        System.out.print("After Modification: ");
        editor.displayText();

        editor.deleteText();
        System.out.print("After Deletion: ");
        editor.displayText();

        editor.insertText("!");
        System.out.print("After Inserting '!': ");
        editor.displayText();

        editor.modifyText(12, '?');
    }
}
