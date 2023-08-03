import java.util.Arrays;

public class LeetCode864 {
    int min = Integer.MAX_VALUE;
    char[][] map;
    int totalKey;
    int[][][] store;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int shortestPathAllKeys(String[] grid) {

        map = new char[grid.length][grid[0].length()];
        int startX = 0;
        int startY = 0;
        totalKey = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                map[i][j] = grid[i].charAt(j);
                if (map[i][j] == '@') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
                    totalKey++;
                }
            }
        }
        store = new int[grid.length][grid[0].length()][(1 << 7) + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                Arrays.fill(store[i][j], Integer.MAX_VALUE);
            }
        }

        dfs(startX, startY, 0, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }

    }

    public boolean isWalk(int x, int y, int key) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return false;
        }
        if (map[x][y] == '#') {
            return false;
        }

        if (Character.isUpperCase(map[x][y])) {
            int idx = map[x][y] - 'A';
            return ((key >> idx) & 1) != 0;
        }
        return true;
    }

    public void dfs(int x, int y, int key, int step) {
        if (step > min) {
            return;
        }
        if (key == (1<<totalKey)-1) {
            min = step;
        }

        if (store[x][y][key] <= step) {
            return;
        }
        store[x][y][key] = step;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isWalk(nx, ny, key)) {
                if (Character.isLowerCase(map[nx][ny])) {
                    int index = map[nx][ny] - 'a';
                    int newKey = key | (1 << index);
                    dfs(nx, ny, newKey, step + 1);
                } else {
                    dfs(nx, ny, key, step + 1);
                }
            }
        }


    }

    public static void main(String[] args) {
        LeetCode864 test = new LeetCode864();
        System.out.println(test.shortestPathAllKeys(new String[]{"@.a.#","###.#","b.A.B"}));
    }
}
