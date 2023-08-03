import java.util.HashSet;
import java.util.Set;

/**
 * @author liuxuezhuo
 */
public class LeetCode1582 {
    int[][] store;
    Set<Integer> row;
    Set<Integer> column;

    public int numSpecial(int[][] mat) {
        store = mat;
        row = new HashSet<>();
        column = new HashSet<>();

        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && checkPosition(i, j)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public boolean checkPosition(int i, int j) {
        if (row.contains(i) || column.contains(j)) {
            return false;
        }
        row.add(i);
        column.add(j);

        for (int k = 0; k < store[i].length; k++) {
            if(store[i][k] == 1 && k != j){
                return false;
            }
        }

        for (int k = 0; k < store.length; k++) {
            if(store[k][j] == 1 && k != i){
                return false;
            }
        }

        return true;
    }
}
