import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1373 {

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left[0] > root.val || right[1] < root.val) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int sum = left[2] + right[2] + root.val;
        ans = Math.max(ans, sum);
        return new int[]{left[0], right[1], sum};
    }

}
