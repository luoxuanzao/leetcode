public class LeetCode670 {

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        int[][] dp = new int[nums.length][2];
        dp[nums.length - 1][0] = nums[nums.length - 1] - '0';
        dp[nums.length - 1][1] = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] - '0' > dp[i + 1][0]) {
                dp[i][0] = nums[i] - '0';
                dp[i][1] = i;
            }else{
                dp[i][0] = dp[i+1][0];
                dp[i][1] = dp[i+1][1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(dp[i][1] != i && dp[i][0] != nums[i] - '0'){
                char temp = nums[dp[i][1]];
                nums[dp[i][1]] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        String result = new String(nums);
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        LeetCode670 test = new LeetCode670();
        test.maximumSwap(2736);
    }
}
