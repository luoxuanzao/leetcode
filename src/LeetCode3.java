import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        while (end < s.length()) {
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            result = Math.max(result, end - start);

            if (start < s.length()) {
                set.remove(s.charAt(start));
            }
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode3 test = new LeetCode3();
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
    }
}
