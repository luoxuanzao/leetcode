public class LeetCode2574 {
    public int[] leftRigthDifference(int[] nums) {
        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < leftSum.length; i++) {
            leftSum[i] = left;
            left += nums[i];

            rightSum[length - i - 1] = right;
            right += nums[length - i - 1];
        }
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }
}
