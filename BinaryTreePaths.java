import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode root = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = node.left;
        node.right = new TreeNode(5);
        List<String> result = binaryTreePaths(root);
        for (String string : result) {
            System.out.println(string);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String res = "";
        dfs(root, res, result);

        return result;

    }

    public static void dfs(TreeNode root, String res, List<String> result) {

        if (root == null) {
            return;
        }

        if (res != "") {
            res += "->" + root.val;
        } else {
            res += root.val;
        }

        if (root.left == null && root.right == null) {
            if (!result.contains(res)) {
                result.add(res);
            }
            return;
        }
        dfs(root.left, res, result);
        dfs(root.right, res, result);

    }
}
