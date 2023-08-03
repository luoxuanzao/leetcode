public class LeetCode1758 {

    public int minOperations(String s) {
        char mark1 = '1';
        char mark2 = '0';
        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (mark1 != s.charAt(i)) {
                ans1++;
            }
            if (mark2 != s.charAt(i)) {
                ans2++;
            }

            mark1 = change(mark1);
            mark2 = change(mark2);

        }
        return Math.min(ans1, ans2);
    }

    public char change(char c) {
        if (c == '1') {
            return '0';
        } else {
            return '1';
        }
    }
}
