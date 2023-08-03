public class LeetCode304 {
    class NumMatrix {
        int[][] matrix;
        int[][] store;

        public int getSum(int x, int y) {
            if (x < 0 || y < 0) {
                return 0;
            }
            return store[x][y];
        }

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            store = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    store[i][j] = matrix[i][j] + getSum(i, j - 1) + getSum(i - 1, j) - getSum(i - 1, j - 1);
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
        }
    }
}
