public class LeetCode931 {
    int[][] dp;
    int[][] matrix;
    boolean[][] visit;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        dp = new int[matrix.length][matrix[0].length];
        visit = new boolean[matrix.length][matrix[0].length];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, get(matrix.length - 1, i));
        }
        return result;
    }

    public int get(int x, int y) {
        if (x == -1) {
            return 0;
        }
        if (visit[x][y]) {
            return dp[x][y];
        }
        int res = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; i++) {
            if (y + i >= 0 && y + i < matrix[0].length) {
                res = Math.min(res, get(x - 1, y + i));
            }
        }
        visit[x][y] = true;
        dp[x][y] = matrix[x][y] + res;
        return dp[x][y];
    }

    public static void main(String[] args) {
        LeetCode931 leetCode931 = new LeetCode931();
        System.out.println(leetCode931.minFallingPathSum(new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));
    }


}
