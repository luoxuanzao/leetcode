import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }


    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            if (left.isEmpty()) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    result.add(root);
                }
            } else if (right.isEmpty()) {
                for (TreeNode r : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = r;
                    result.add(root);
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        result.add(root);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode95 test = new LeetCode95();
        test.generateTrees(3);
    }
}
