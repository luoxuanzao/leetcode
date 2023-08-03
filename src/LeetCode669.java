/**
 * @author liuxuezhuo
 */
public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return cal(root, low, high);
    }

    public TreeNode cal(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return cal(root.right, low, high);
        } else if (root.val > high) {
            return cal(root.left, low, high);
        } else {
            root.left = cal(root.left, low, high);
            root.right = cal(root.right, low, high);
        }
        return root;
    }
}
