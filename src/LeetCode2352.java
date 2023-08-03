import java.util.HashMap;
import java.util.Map;


public class LeetCode2352 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>(16);
        StringBuilder stringBuilder;
        for (int[] ints : grid) {
            stringBuilder = new StringBuilder();
            for (int anInt : ints) {
                stringBuilder.append(anInt).append(",");
            }
            map.merge(stringBuilder.toString(), 1, Integer::sum);
        }
        int result = 0;

        for (int i = 0; i < grid[0].length; i++) {
            stringBuilder = new StringBuilder();

            for (int[] ints : grid) {
                stringBuilder.append(ints[i]).append(",");
            }

            result += map.getOrDefault(stringBuilder.toString(), 0);

        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode2352 main = new LeetCode2352();
//        main.equalPairs(new int[][]{
//                {3, 2, 1},
//                {1, 7, 6},
//                {2, 7, 7},
//        });

        main.equalPairs(new int[][]{
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        });
    }

}
