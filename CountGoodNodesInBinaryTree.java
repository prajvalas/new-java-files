class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(5);
        node.right = new TreeNode(-2);
        node = node.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(4);

    }

    public int goodNodes(TreeNode root) {
        return binaryTree(root, root.val) + 1;
    }

    public int binaryTree(TreeNode root, int high) {
        int count = 0;
        int highest = high;

        if (root.left != null && root.left.val >= high) {
            count++;
            highest = root.left.val;
        }
        if (root.left != null) {
            count += binaryTree(root.left, highest);
        }
        if (root.right != null && root.right.val >= high) {
            count++;
            high = root.right.val;
        }
        if (root.right != null) {
            count += binaryTree(root.right, high);
        }
        return count;
    }
}