class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private QueueNode front, rear;
    private int size;
    private java.util.Stack<Integer> minStack;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.minStack = new java.util.Stack<>();
    }

    public void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        int value = front.data;
        front = front.next;

        if (!minStack.isEmpty() && value == minStack.peek()) {
            minStack.pop();
        }

        size--;
        if (front == null) {
            rear = null;
        }

        return value;
    }

    public int getMinimum() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return minStack.peek();
    }

    public void reverseFirstK(int k) {
        if (k <= 0 || k > size) {
            throw new IllegalArgumentException("Invalid value of K");
        }

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(dequeue());
        }

        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }

        for (int i = 0; i < size - k; i++) {
            enqueue(dequeue());
        }
    }

    public void printQueue() {
        QueueNode current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Original Queue:");
        queue.printQueue();

        System.out.println("Minimum element: " + queue.getMinimum());

        int k = 3;
        queue.reverseFirstK(k);

        System.out.println("Queue after reversing first " + k + " elements:");
        queue.printQueue();

        System.out.println("Minimum element after reversal: " + queue.getMinimum());
    }
}
