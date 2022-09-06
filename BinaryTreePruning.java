public class BinaryTreePruning {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.right = new TreeNode(0);
        node = node.right;
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);
        TreeNode result = pruneTree(root);
        System.out.println(result.val);

    }

    public static TreeNode pruneTree(TreeNode root) {
        TreeNode r = root;
        if (dfs(root)) {
            return null;
        }
        return r;
    }

    public static boolean dfs(TreeNode root) {
        int count = 0;
        if (root.left == null && root.right == null && root.val == 0) {
            return true;
        }
        if (root.left != null) {
            if (dfs(root.left)) {
                root.left = null;
                count++;
            }
        } else {
            count++;
        }
        if (root.right != null) {
            if (dfs(root.right)) {
                root.right = null;
                count++;
            }
        } else {
            count++;
        }
        if (root.val == 0) {
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
