public class LeetCode1779 {
    int x;
    int y;

    public int nearestValidPoint(int x, int y, int[][] points) {
        this.y = y;
        this.x = x;
        int distance = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            if (is_match(points[i][0], points[i][1])) {
                int temp = calDistance(x, y, points[i][0], points[i][1]);
                if (distance > temp){
                    distance = temp;
                    result = i;
                }
            }
        }
        return result;
    }

    public boolean is_match(int x, int y) {
        return this.x == x || this.y == y;
    }

    public int calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
