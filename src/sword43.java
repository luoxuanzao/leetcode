import java.util.Arrays;

public class sword43 {

    int count = 0;
    char[] nums;
    int[][] dp;

    public int countDigitOne(int n) {
        nums = String.valueOf(n).toCharArray();
        int length = nums.length;
        int dp[][] = new int[length][length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return helper(0, true, false, 0);
    }

    public int helper(int position, boolean limit, boolean isNum, int count) {
        if (position == nums.length) {
            return isNum ? count : 0;
        }

        if (isNum && dp[position][count] != -1) {
            return dp[position][count];
        }

        int res = 0;

        if (!isNum) {
            res = helper(position + 1, false, false, count);
        }

        int up = limit ? nums[position] - '0' : 9;
        for (int i = isNum ? 0 : 1; i <= up; i++) {
            if (i == 1) {
                res += helper(position + 1, limit && i == up, true, count + 1);
            } else {
                res += helper(position + 1, limit && i == up, true, count);
            }
        }

        if (isNum) {
            dp[position][count] = res;
        }

        return res;
    }

    public static void main(String[] args) {
        sword43 t = new sword43();
        System.out.println(t.countDigitOne(11));
    }

}
