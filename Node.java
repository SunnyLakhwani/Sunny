class Node {
    int studentID;
    Node next;

    Node(int id) {
        this.studentID = id;
        this.next = null;
    }
}

class StudentList {
    private Node head;


    public int getLength() {
        int count = 0;
        for (Node current = head; current != null; current = current.next) {
            count++;
        }
        return count;
    }


    public void deleteFirst() {
        if (head == null) {
            System.out.println("No students to remove.");
        } else {
            head = head.next;
        }
    }

    public Integer getStudentAt(int index) {
        if (index < 0 || index >= getLength()) {
            System.out.println("Invalid index.");
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.studentID;
    }

    public StudentList merge(StudentList other) {
        StudentList mergedList = new StudentList();
        Node current1 = this.head, current2 = other.head;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                mergedList.add(current2.studentID);
                current2 = current2.next;
            } else if (current2 == null) {
                mergedList.add(current1.studentID);
                current1 = current1.next;
            } else if (current1.studentID < current2.studentID) {
                mergedList.add(current1.studentID);
                current1 = current1.next;
            } else {
                mergedList.add(current2.studentID);
                current2 = current2.next;
            }
        }
        return mergedList;
    }

    private void add(int id) {
        Node newNode = new Node(id);
        if (head == null || head.studentID >= id) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.studentID < id) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public StudentList reverse() {
        StudentList reversedList = new StudentList();
        for (Node current = head; current != null; current = current.next) {
            reversedList.add(current.studentID);
        }
        return reversedList;
    }
        public static void main(String[] args) {

            StudentList list1 = new StudentList();
            list1.add(101);
            list1.add(103);
            list1.add(105);

            StudentList list2 = new StudentList();
            list2.add(102);
            list2.add(104);
            list2.add(106);

            System.out.println("Length of List 1: " + list1.getLength());
            System.out.println("Length of List 2: " + list2.getLength());

            StudentList mergedList = list1.merge(list2);
            System.out.println("Merged List Length: " + mergedList.getLength());

            for (int i = 0; i < mergedList.getLength(); i++) {
                System.out.print(mergedList.getStudentAt(i) + " ");
            }
            System.out.println();

            StudentList reversedList = mergedList.reverse();
            System.out.println("Reversed Merged List Length: " + reversedList.getLength());

            for (int i = 0; i < reversedList.getLength(); i++) {
                System.out.print(reversedList.getStudentAt(i) + " ");
            }
        }
    }


