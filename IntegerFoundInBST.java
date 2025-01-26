import java.util.Scanner;

class IntegerFoundInBST {
    private class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    private Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        if (value > root.value) {
            return searchRec(root.right, value);
        }

        return searchRec(root.left, value);
    }

    public static void main(String[] args) {
        IntegerFoundInBST bst = new IntegerFoundInBST();

        int[] inputArray = {50, 30, 70, 20, 40, 60, 80};

        for (int value : inputArray) {
            bst.insert(value);
        }

        System.out.print("In-order Traversal: ");
        bst.inorder();

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer to search: ");
        int searchValue = scanner.nextInt();

        if (bst.search(searchValue)) {
            System.out.println(searchValue + " is found in the BST.");
        } else {
            System.out.println(searchValue + " is not found in the BST.");
        }

        scanner.close();
    }
}
