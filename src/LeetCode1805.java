import java.util.HashSet;
import java.util.Set;

public class LeetCode1805 {
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                chars[i] = ' ';
            }
        }
        String nums = new String(chars);
        Set<String> n = new HashSet<>();
        for (String s : nums.split(" ")) {
            if (s.length() > 0) {
                n.add(s);
            }
        }
        return n.size();
    }
}
