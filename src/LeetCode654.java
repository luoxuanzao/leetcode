public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxIndex = start;
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 test = new LeetCode654();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode node = test.constructMaximumBinaryTree(nums);
    }
}
