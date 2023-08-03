public class LeetCode1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                result[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return result;
    }
}
