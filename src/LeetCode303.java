import java.util.HashSet;

public class LeetCode303 {
    class NumArray {
        int[] n;
        int[] sums;

        public NumArray(int[] nums) {
            n = nums;
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i] = sum;
                sum = sum + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right] - sums[left];
        }
    }


}
