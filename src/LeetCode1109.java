import java.util.Arrays;

public class LeetCode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];

        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int count = booking[2];
            diff[start] += count;
            diff[end + 1] -= count;
        }

        int pre = 0;
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = pre + diff[i];
            pre = result[i];
        }
        return result;
    }
}
