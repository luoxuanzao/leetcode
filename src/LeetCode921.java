public class LeetCode921 {

    public int minAddToMakeValid(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
                if (count < 0) {
                    ans += 1;
                    count = 0;
                }
            }
        }
        return count + ans;
    }
}
