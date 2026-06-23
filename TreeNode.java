class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class BinaryTree {

    public static int calculateLevel(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(calculateLevel(root.left), calculateLevel(root.right)) + 1;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static boolean isComplete(TreeNode root, int index, int numberNodes) {
        if (root == null) return true;
        if (index >= numberNodes) return false;
        return isComplete(root.left, 2 * index + 1, numberNodes) &&
                isComplete(root.right, 2 * index + 2, numberNodes);
    }

    public static boolean isFull(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) return isFull(node.left) && isFull(node.right);
        return false;
    }

    public static boolean checkChildrenSumProperty(TreeNode node)
    {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        int leftValue = (node.left != null) ? node.left.data : 0;
        int rightValue = (node.right != null) ? node.right.data : 0;

        return (node.data == leftValue + rightValue) &&
                checkChildrenSumProperty(node.left) &&
                checkChildrenSumProperty(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        int levels = calculateLevel(root);
        System.out.println("Number of levels in the binary tree: " + levels);

        int nodeCount = countNodes(root);
        boolean complete = isComplete(root, 0, nodeCount);
        boolean full = isFull(root);

        System.out.println("Is Complete: " + complete);
        System.out.println("Is Full: " + full);

        boolean propertyHolds = checkChildrenSumProperty(root);

        System.out.println("Children Sum Property holds: " + propertyHolds);
    }
}
