import java.util.ArrayList;
import java.util.Comparator;

public class LeetCode6216 {

    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], cost[i]});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 计算ab b
        long[] f = new long[nums.length];
        long[] g = new long[nums.length];
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i - 1] + (long) list.get(i)[0] * list.get(i)[1];
            g[i] = g[i - 1] + list.get(i)[1];
        }
        int n = list.size();
        for (int i = 1; i <= list.size(); i++) {
            long l = list.get(i - 1)[0] * g[i - 1] - f[i - 1];
            long r = (f[n] - f[i]) - list.get(i - 1)[0] * (g[n] - g[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;


    }


}
