public class LeetCode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        int maxStep = Integer.MIN_VALUE;
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1] - 1;
            int end = trips[i][2] - 1;
            diff[start] += num;
            diff[end] -= num;
            maxStep = Math.max(maxStep, end);
        }
        int current = 0;
        for (int i = 0; i < maxStep; i++) {
            current = current + diff[i];
            if (current > capacity) {
                return false;
            }
        }
        return true;
    }
}
