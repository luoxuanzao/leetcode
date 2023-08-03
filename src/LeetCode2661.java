import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        int[] line = new int[m];
        int[] column = new int[n];
        Arrays.fill(line, n);
        Arrays.fill(column, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] index = new int[]{i, j};
                map.put(mat[i][j], index);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] index = map.get(arr[i]);
            line[index[0]]--;
            column[index[1]]--;
            if (line[index[0]] == 0 || column[index[1]] == 0) {
                return i;
            }
        }
        return -1;
    }
}
