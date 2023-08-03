public class LeetCode2379 {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        int L = 0;
        int R = 0;
        for (; R < k; R++) {
            if (blocks.charAt(R) == 'W') {
                count += 1;
            }
        }
        int result = count;
        while (R < blocks.length()) {
            count += blocks.charAt(R) == 'W' ? 1 : 0;
            count -= blocks.charAt(L) == 'W' ? 1 : 0;
            R++;
            L++;
            result = Math.min(result, count);
        }
        return result;
    }
}
