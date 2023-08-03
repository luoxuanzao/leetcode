import java.util.*;

public class LeetCode6308 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Long> nums = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            long sum = 0;
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.peek();
                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    sum += node.val;
                }
                queue.pop();
            }
            nums.add(sum);
        }
        nums.sort((o1, o2) -> {
            if (o2 < o1) {
                return 1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return -1;
            }
        });

        if (k > nums.size()) {
            return -1;
        }
        return nums.get(k - 1);
    }
}
