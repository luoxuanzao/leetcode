public class LeetCode775 {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
