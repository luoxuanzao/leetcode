import java.util.Arrays;

public class LeetCode1335 {
    int[][] memory;
    int[] jobs;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int jobLength = jobDifficulty.length;
        if (jobLength < d){
            return -1;
        }

        jobs = jobDifficulty;
        memory = new int[jobLength][d];
        for (int[] ints : memory) {
            Arrays.fill(ints, -1);
        }
        return dfs(jobLength - 1, d - 1);

    }

    public int dfs(int i, int j) {
        if (memory[i][j] != -1) {
            return memory[i][j];
        }
        if (j == 0) {
            int result = 0;
            for (int k = 0; k <= i; k++) {
                result = Math.max(result, jobs[k]);
            }
            return result;
        }
        int max = 0;
        int result = Integer.MAX_VALUE;
        for (int k = i; k >= j; k--) {
            max = Math.max(max, jobs[k]);
            result = Math.min(result, max + dfs(k-1,j-1));
        }

        memory[i][j] = result;
        return memory[i][j];
    }

    public static void main(String[] args) {
        LeetCode1335 main = new LeetCode1335();
        System.out.println(main.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(main.minDifficulty(new int[]{7,1,7,1,7,1}, 3));
        System.out.println(main.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
    }
}
