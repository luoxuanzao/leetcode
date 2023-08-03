/**
 * @author liuxuezhuo
 */
public class LeetCode1475 {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    count = prices[j];
                    break;
                }
            }
            result[i] = prices[i] - count;
        }
        return result;
    }
}
