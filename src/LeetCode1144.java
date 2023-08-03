public class LeetCode1144 {
    public int movesToMakeZigzag(int[] nums) {
        int numOdd = 0;
        int numEven = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;

            if (i - 1 >= 0) {
                min = Math.min(min, nums[i - 1]);
            }
            if (i + 1 < nums.length) {
                min = Math.min(min, nums[i + 1]);
            }
            if (i % 2 == 0) {
                numEven += (nums[i] < min ? 0 : nums[i] - min + 1);
            } else {
                numOdd += (nums[i] < min ? 0 : nums[i] - min + 1);

            }
        }
        return Math.min(numOdd, numEven);
    }
}
