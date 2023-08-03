import java.util.ArrayList;
import java.util.List;

public class LeetCode655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = calHeight(root);
        int n = (int) (Math.pow(2, height) - 1);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> subList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                subList.add("");
            }
            result.add(subList);
        }

        setValue(root, 0, (n - 1) / 2, result, height);

        return result;
    }

    public int calHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(calHeight(root.right), calHeight(root.left)) + 1;
    }

    public void setValue(TreeNode root, int m, int n, List<List<String>> result, int totalHeight) {
        if (root == null) {
            return;
        }
        int gap = (int) Math.pow(2, Math.max(totalHeight - m - 2, 0));
        result.get(m).set(n, String.valueOf(root.val));
        setValue(root.left, m + 1, n - gap, result, totalHeight);
        setValue(root.right, m + 1, n + gap, result, totalHeight);
    }
}
