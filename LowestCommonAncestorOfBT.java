public class LowestCommonAncestorOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = root;
        node.left = new TreeNode(5);
        TreeNode p = node.left;
        node.right = new TreeNode(1);
        TreeNode node2 = node.right;
        // TreeNode q = node2;
        node = node.left;
        node.left = new TreeNode(6);
        node.right = new TreeNode(2);
        node = node.right;
        node.left = new TreeNode(7);
        node.right = new TreeNode(4);
        TreeNode q = node.right;
        node2.left = new TreeNode(0);
        node2.right = new TreeNode(8);
        System.out.println("Lowest common ancestor is : " + lowestCommonAncestor(root, p, q).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // if(left.val != root.val && root.val != right.val){
            return root;
            // }
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }
        return null;
    }
}
