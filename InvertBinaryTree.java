public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node = root;
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        TreeNode result = invertTree(root);
        System.out.println(result.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        TreeNode r = root;
        dfs(root);
        return r;
    }

    public static void dfs(TreeNode root) {
        TreeNode tempL = null;
        TreeNode tempR = null;
        if (root == null) {
            return;
        }
        if (root.left != null) {
            tempL = root.left;
        }
        if (root.right != null) {
            tempR = root.right;
        }
        root.left = tempR;
        root.right = tempL;
        dfs(root.left);
        dfs(root.right);
    }
}
