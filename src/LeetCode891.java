import java.util.Arrays;

public class LeetCode891 {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        final int MOD = (int) 1e9 + 7;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += (nums[j] - nums[i]) * Math.pow(2, j - i - 1);
                result %= MOD;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode891 test = new LeetCode891();
        System.out.println(test.sumSubseqWidths(new int[]{1, 2, 3}));
    }
}
