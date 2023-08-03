public class LeetCode997 {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0];
            int y = edge[1];
            inDegrees[x]++;
            outDegrees[y]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0 && outDegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
