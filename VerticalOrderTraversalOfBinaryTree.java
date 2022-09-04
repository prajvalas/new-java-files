import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode root = node;
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        TreeNode node1 = node.right;
        node = node.left;
        node.left = new TreeNode(12);
        node.right = new TreeNode(6);
        node1.left = new TreeNode(15);
        node1.right = new TreeNode(7);

        List<List<Integer>> result = verticalTraversal(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> main_map = new TreeMap<>();
        dfs(root, main_map, 0, 0);

        for (Integer key : main_map.keySet()) {
            map = main_map.get(key);
            List<Integer> l = new ArrayList<>();
            for (Integer key1 : map.keySet()) {
                if (map.get(key1).size() > 1) {
                    Collections.sort(map.get(key1));
                }
                for (Integer i : map.get(key1)) {
                    l.add(i);
                }

            }
            result.add(l);
        }

        return result;

    }

    public static void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> main_map, int row,
            int column) {
        if (root == null) {
            return;
        }
        if (!main_map.containsKey(column)) {
            main_map.put(column, new TreeMap<>());
        }
        if (!main_map.get(column).containsKey(row)) {
            main_map.get(column).put(row, new ArrayList<>());
        }
        main_map.get(column).get(row).add(root.val);

        dfs(root.left, main_map, row + 1, column - 1);
        dfs(root.right, main_map, row + 1, column + 1);
    }

}
