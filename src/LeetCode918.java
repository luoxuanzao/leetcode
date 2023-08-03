public class LeetCode918 {
    public int maxSubarraySumCircular(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length];
        int[] leftMax = new int[nums.length];
        int[] leftSum = new int[nums.length];
        dp[0] = nums[0];
        leftMax[0] = nums[0];
        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
            leftSum[i] = leftSum[i - 1] + nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum[i]);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            int right = leftSum[nums.length - 1] - leftSum[j - 1];
            result = Math.max(result, right + leftMax[j - 1]);
        }
        return result;
    }
}
