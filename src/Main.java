

public class Main {

    int[] coins = new int[]{5, 2, 1};

    public int dfs(int leftCount) {
        if (leftCount == 0) {
            return 0;
        }
        if (leftCount < 0) {
            return -1;
        }
        for (int coin : coins) {
            int times = dfs(leftCount - coin);
            if (times > 0) {
                return times + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
