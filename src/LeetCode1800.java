public class LeetCode1800 {
    public int maxAscendingSum(int[] nums) {
        int result = nums[0];
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                count += nums[i];
            } else {
                count = nums[i];
            }
            result = Math.max(result, count);

        }
        return result;
    }
}
