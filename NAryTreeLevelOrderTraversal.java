import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        List<Node> children_child1 = new ArrayList<>();
        Node child1_child1 = new Node(5);
        Node child1_child2 = new Node(6);
        children_child1.add(child1_child1);
        children_child1.add(child1_child2);

        List<Node> children = new ArrayList<>();
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4, children_child1);
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Node root = new Node(1, children);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);

    }

    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result, 0);

        return result;
    }

    public static void dfs(Node root, List<List<Integer>> result, int count) {
        if (root == null) {
            return;
        }

        if (result.size() <= count) {
            result.add(count, new ArrayList<>());
        }
        result.get(count).add(root.val);

        if (root.children != null) {
            for (Node node : root.children) {
                dfs(node, result, count + 1);
            }
        }

        return;
    }
}
