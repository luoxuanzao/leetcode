import java.util.HashMap;
import java.util.Map;

public class LeetCode1620 {
    private int[][] t;
    private int r;

    public int[] bestCoordinate(int[][] towers, int radius) {
        r = radius;
        t = towers;
        int xMin = 0, xMax = towers[0][0], yMin = 0, yMax = towers[0][1];

        int max = Integer.MIN_VALUE;
        Map<Integer, int[]> store = new HashMap<>(16);

        for (int[] tower : towers) {
            xMax = Math.max(xMax, tower[0]);
            yMax = Math.max(yMax, tower[1]);
        }
        for (int i = xMax; i >= xMin; i--) {
            for (int j = yMax; j >= yMin; j--) {
                int count = count(i, j);
                if (max < count) {
                    max = count;
                }

                store.put(count, new int[]{i, j});
            }
        }

        return store.get(max);
    }


    public int count(int x, int y) {
        int[] target = new int[]{x, y};
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            double distance = calDistance(target, t[i]);
            if (distance >= 0) {
                count += (int) Math.floor(t[i][2] / (1 + distance));
            }
        }
        return count;
    }

    public double calDistance(int[] point1, int[] point2) {
        double distance = (Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
        if (distance > Math.pow(r, 2)) {
            return -1;
        } else {
            return Math.pow(distance, 0.5);
        }
    }

    public static void main(String[] args) {
        LeetCode1620 test = new LeetCode1620();
        int[][] nums = new int[3][3];
        nums[0] = new int[]{1, 2, 5};
        nums[1] = new int[]{2, 1, 7};
        nums[2] = new int[]{3, 1, 9};

        test.bestCoordinate(nums, 2);
    }
}
