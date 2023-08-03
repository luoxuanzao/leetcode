import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1080 {

    int limit;


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        if (dfs(root, 0)) {
            return root;
        } else {
            return null;
        }

    }

    public boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }

        boolean left = dfs(node.left, sum + node.val);
        boolean right = dfs(node.right, sum + node.val);
        if (!left) {
            node.left = null;
        }
        if (!right) {
            node.right = null;
        }

        return left || right;
    }
}
