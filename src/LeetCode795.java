public class LeetCode795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                if (max <= right && max >= left) {
                    result += 1;
                }
            }
        }


        return result;
    }
}
