import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        List<Pair<Integer, Integer>> directions = new ArrayList<>();
        directions.add(new Pair<>(0, 1));
        directions.add(new Pair<>(1, 0));
        directions.add(new Pair<>(0, -1));
        directions.add(new Pair<>(-1, 0));
        int currentIndex = 0;
        int[][] result = new int[n][n];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], -1);
        }

        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            result[x][y] = i;
            int nextX = x + directions.get(currentIndex).getKey();
            int nextY = y + directions.get(currentIndex).getValue();
            if (nextY == n || nextX == n || nextX < 0 || nextY < 0 || result[nextX][nextY] != -1) {
                currentIndex = (currentIndex + 1) % directions.size();
            }
            x += directions.get(currentIndex).getKey();
            y += directions.get(currentIndex).getValue();

        }
        return result;
    }
}
