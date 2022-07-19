public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node = root;
        node.left = new TreeNode(2);
        // TreeNode p = node.left;
        node.right = new TreeNode(8);
        // TreeNode q = node.right;
        TreeNode left = node.left;
        TreeNode right = node.right;
        left.left = new TreeNode(0);
        TreeNode p = left.left;
        left.right = new TreeNode(4);
        // TreeNode q = left.right;
        right.left = new TreeNode(7);
        right.right = new TreeNode(9);
        right = left.right;
        right.left = new TreeNode(3);
        right.right = new TreeNode(5);
        TreeNode q = right.right;

        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest common ancestor is : " + result.val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            return root;
        } else if (p.val == root.val || q.val == root.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

// Random comment