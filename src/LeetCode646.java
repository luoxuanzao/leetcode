import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuxuezhuo
 */
public class LeetCode646 {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] <= o2[0]) {
                    return -1;
                } else {
                    return 1;
                }

            }
        });

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;

                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        LeetCode646 test = new LeetCode646();
        int[][] nums = new int[][]{{2, 3}, {3, 4}, {1, 2}};
        System.out.println(test.findLongestChain(nums));

    }
}
