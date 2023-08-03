public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                int leftUp = matrix[i][j];
                int rightUp = matrix[j][length - 1 - i];
                int rightDown = matrix[length - 1 - i][length - 1 - j];
                int leftDown = matrix[length - 1 - j][i];
                matrix[i][j] = leftDown;
                matrix[j][length - 1 - i] = leftUp;
                matrix[length - 1 - i][length - 1 - j] = rightUp;
                matrix[length - 1 - j][i] = rightDown;
            }
        }
    }
}
