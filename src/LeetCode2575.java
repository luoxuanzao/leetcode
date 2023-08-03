public class LeetCode2575 {
    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        char[] nums = word.toCharArray();
        long num = 0;

        for (int i = 0; i < nums.length; i++) {
            num *= 10;
            num += nums[i] - '0';
            num = num % m;
            if (num % m == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
