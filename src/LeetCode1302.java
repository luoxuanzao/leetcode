import java.util.HashMap;
import java.util.Map;

public class LeetCode1302 {
    int maxDeep = 0;

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        return map.getOrDefault(maxDeep, 0);
    }

    public void dfs(TreeNode root, Map<Integer, Integer> map, int deep) {
        if (root == null) {
            return;
        }
        maxDeep = Math.max(maxDeep, deep);
        map.put(deep, map.getOrDefault(deep, 0) + root.val);
        dfs(root.left, map, deep + 1);
        dfs(root.right, map, deep + 1);
    }

}
