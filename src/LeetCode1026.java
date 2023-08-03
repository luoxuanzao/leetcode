import java.util.ArrayList;
import java.util.Deque;

public class LeetCode1026 {
    int result = Integer.MIN_VALUE;
    ArrayList<Integer> ancestor = new ArrayList<>();

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return result;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        for (Integer integer : ancestor) {
            result = Math.max(result, node.val - integer);
        }

        ancestor.add(node.val);
        dfs(node.left);
        dfs(node.right);
        ancestor.remove(ancestor.size() - 1);
    }
}
