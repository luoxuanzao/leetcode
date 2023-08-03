public class LeetCode2663 {
    public String smallestBeautifulString(String s, int k) {
        char[] letters = s.toCharArray();
        int n = s.length();
        char up = (char) ('a' + k);
        int i = n - 1;
        letters[i]++;
        while (i < n) {
            if (letters[i] == up) {
                if (i == 0) {
                    return "";
                }
                letters[i] = 'a';
                i--;
                letters[i]++;

            } else if (i > 0 && letters[i - 1] == letters[i] || i > 1 && letters[i - 2] == letters[i]) {
                letters[i]++;

            } else {
                i++;
            }
        }

        return new String(letters);
    }

    public static void main(String[] args) {
        LeetCode2663 test = new LeetCode2663();
        test.smallestBeautifulString("abcz", 26);
    }
}
