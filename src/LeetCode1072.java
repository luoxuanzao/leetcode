import java.util.HashMap;
import java.util.Map;

public class LeetCode1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            char[] s = new char[column];
            for (int i1 = 0; i1 < column; i1++) {
                if (matrix[i][0] == 1) {
                    s[i1] = (char) ((char) matrix[i][i1] ^ 1);
                } else {
                    s[i1] = (char) matrix[i][i1];
                }
            }
            String str = new String(s);
            map.put(str, map.getOrDefault(str, 0) + 1);
            ans = Math.max(ans, map.get(str));
        }
        return ans;
    }
}
