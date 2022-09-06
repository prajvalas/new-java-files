public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node = root;
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        int result = maxDepth(root);
        System.out.println("Maximum Depth of Binary Tree is : " + result);
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        return Math.max(dfs(root.left, depth + 1), dfs(root.right, depth + 1));
    }
}
