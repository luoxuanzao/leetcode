import java.util.HashMap;
import java.util.Map;

public class LeetCode662 {
    Map<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode root, int index, int depth) {
        if (root == null) {
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) + 1, Math.max(dfs(root.left, index * 2, depth + 1), dfs(root.right, index * 2 + 1, depth + 1)));
    }

    public void test(){
        System.out.println(1);
    }

}
