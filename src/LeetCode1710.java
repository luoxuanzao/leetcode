import java.util.Arrays;

public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int count = Math.min(truckSize, boxTypes[i][0]);
            ans += count * boxTypes[i][1];
            truckSize -= count;
            if (truckSize <= 0) {
                break;
            }
        }
        return ans;
    }
}
