public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = current;
        for (int g : gain) {
            current += g;
            max = Math.max(max, current);
        }
        return max;
    }

}
