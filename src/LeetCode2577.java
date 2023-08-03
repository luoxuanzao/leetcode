import java.util.*;

public class LeetCode2577 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;

        int[][] dis = new int[m][n];

        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        p.add(new int[]{0, 0, 0});
        dis[0][0] = 0;
        while (!p.isEmpty()) {
            int[] peek = p.poll();
            int cost = peek[0];
            int x = peek[1];
            int y = peek[2];

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return cost;
            }

            for (int[] ints : direction) {
                int newX = x + ints[0];
                int newY = y + ints[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int minCost = Math.max(cost + 1, grid[newX][newY]);
                    int count = minCost % 2 == (newX + newY) % 2 ? minCost : minCost + 1;
                    if (count < dis[newX][newY]) {
                        dis[newX][newY] = count;
                        p.add(new int[]{count, newX, newY});
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode2577 leetCode2577 = new LeetCode2577();
//        int[][] nums = new int[][]{
//                {0, 1, 3, 2},
//                {5, 1, 2, 5},
//                {4, 3, 8, 6}
//        };

        int[][] nums = new int[][]{
                {0, 2, 4},
                {3, 2, 1},
                {1, 0, 4}
        };


        System.out.println(leetCode2577.minimumTime(nums));
    }
}
