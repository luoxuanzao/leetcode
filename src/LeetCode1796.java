public class LeetCode1796 {
    public int secondHighest(String s) {
        int max = -1;
        int result = -1;
        char[] store = s.toCharArray();
        for (int i = 0; i < store.length; i++) {
            if (Character.isDigit(store[i])) {
                if (store[i] - '0' > max) {
                    result = max;
                    max = store[i] - '0';
                } else if (store[i] - '0' > result) {
                    result = store[i] - '0';
                }
            }
        }
        return result;
    }
}
