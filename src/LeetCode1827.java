public class LeetCode1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current) {
                current = nums[i];
            } else {
                ans += current - nums[i] + 1;
                current += 1;
            }
        }
        return ans;
    }
}
