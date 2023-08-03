import java.util.Arrays;

public class LeetCode370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        Arrays.fill(diff, 0);
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int add = update[2];
            diff[start] += add;
            diff[end + 1] -= add;
        }
        int[] result = new int[length];
        int pre = 0;
        for (int i = 0; i < length; i++) {
            result[i] = diff[i] + pre;
            pre = result[i];
        }
        return result;
    }
}
