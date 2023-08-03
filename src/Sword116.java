public class Sword116 {
    int[] fa;


    public int findCircleNum(int[][] isConnected) {
        fa = new int[isConnected.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < fa.length; i++) {
            if (fa[i] == i) {
                result++;
            }
        }
        return result;
    }

    public int find(int x) {
        if (fa[x] == x) {
            return x;
        }
        return find(fa[x]);
    }

    public void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        fa[fx] = fy;
    }


}
