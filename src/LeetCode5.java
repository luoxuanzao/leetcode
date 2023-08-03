public class LeetCode5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 0;
        int begin = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1)) {
                    if (i < 3) {
                        isPalindrome[j][j + i - 1] = true;
                    } else {
                        isPalindrome[j][j + i - 1] = isPalindrome[j + 1][j + i - 2];
                    }
                } else {
                    isPalindrome[j][j + i - 1] = false;
                }
                if (isPalindrome[j][j + i - 1] && i > maxLen) {
                    maxLen = i;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        LeetCode5 test = new LeetCode5();
        test.longestPalindrome("bb");
    }
}
