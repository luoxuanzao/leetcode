import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1091 {
    Deque<int[]> deque;
    boolean[][] visit;
    int[][] dis;
    int[][] direction = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1},
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        deque = new ArrayDeque<>();
        visit = new boolean[grid.length][grid[0].length];
        dis = new int[grid.length][grid[0].length];

        if (grid[0][0] != 0) {
            return -1;
        }
        deque.add(new int[]{0, 0});
        dis[0][0] = 1;
        while (!deque.isEmpty()) {
            int[] item = deque.removeFirst();
            int x = item[0];
            int y = item[1];
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return dis[x][y];
            }
            for (int[] ints : direction) {
                int newX = x + ints[0];
                int newY = y + ints[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                        grid[newX][newY] == 0 && !visit[newX][newY]) {
                    deque.add(new int[]{newX, newY});
                    visit[newX][newY] = true;
                    dis[newX][newY] = dis[x][y] + 1;
                }
            }
        }

        return -1;
    }
}
