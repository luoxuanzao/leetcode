public class LeetCode6307 {
    public int passThePillow(int n, int time) {
        int direction = 1;
        int current = 1;
        for (int i = 0; i < time; i++) {
            if (direction == 1) {
                if (current == n) {
                    direction = -1;
                }
                current += direction;
            } else {
                if (current == 1) {
                    direction = 1;
                }
                current += direction;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        LeetCode6307 t = new LeetCode6307();
        System.out.println(t.passThePillow(3, 2));
    }
}
