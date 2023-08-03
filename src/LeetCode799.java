public class LeetCode799 {


    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] nums = new double[query_row + 2][query_row + 2];
        nums[0][0] = poured;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i][j] > 1) {
                    nums[i + 1][j] += (nums[i][j] - 1) / 2;
                    nums[i + 1][j + 1] += (nums[i][j] - 1) / 2;
                    nums[i][j] = 1;
                }
            }
        }
        return nums[query_row][query_glass];
    }

    public static void main(String[] args) {
        LeetCode799 test = new LeetCode799();
        System.out.println(test.champagneTower(100000009, 33, 17));
    }
}