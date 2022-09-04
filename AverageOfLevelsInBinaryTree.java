import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(9);
        TreeNode root = node;
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        TreeNode node1 = node.right;
        node = node.left;
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node1.left = new TreeNode(5);
        // node1.right = new TreeNode(6);
        List<Double> result = new ArrayList<>();
        result = averageOfLevels(root);
        for (Double double1 : result) {
            System.out.println(double1);
        }

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        binaryTreeAverage(root, result, level, 0);
        for (int i = 1; i < result.size(); i++) {
            result.set(i, result.get(i) / level.get(i));
        }
        return result;

    }

    public static void binaryTreeAverage(TreeNode root, List<Double> result, List<Integer> level, int pass) {

        if (root == null) {
            return;
        }
        if (pass < result.size()) {
            result.set(pass, result.get(pass) + root.val);
            level.set(pass, level.get(pass) + 1);
        } else {
            result.add((double) root.val);
            level.add(1);
        }

        binaryTreeAverage(root.left, result, level, pass + 1);
        binaryTreeAverage(root.right, result, level, pass + 1);

    }
}
