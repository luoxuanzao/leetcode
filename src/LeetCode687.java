
/**
 * @author liuxuezhuo
 */
public class LeetCode687 {
    int MaxDepth = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return MaxDepth;
    }

    public void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        MaxDepth = Math.max(calNode(root.left, root.val) + calNode(root.right, root.val), MaxDepth);
        dfs(root.left);
        dfs(root.right);
    }

    public int calNode(TreeNode root, int targetValue) {
        if (root == null || root.val != targetValue) {
            return 0;
        }
        return 1 + Math.max(calNode(root.left, targetValue), calNode(root.right, targetValue));
    }

}
