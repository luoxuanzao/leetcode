public class LeetCode2373 {
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] result = new int[length - 2][length - 2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = getMax(i + 1, j + 1, grid);
            }
        }
        return result;
    }

    public int getMax(int x, int y, int[][] grid) {
        int result = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                result = Math.max(result, grid[i][j]);
            }
        }
        return result;
    }
}
