import java.util.HashSet;
import java.util.Set;

public class LeetCode1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        for (int i = 0; i < words.length; i++) {
            if (check(set, words[i])) {
                result++;
            }
        }
        return result;
    }

    public boolean check(Set<Character> set, String word) {
        for (int j = 0; j < word.length(); j++) {
            if (!set.contains(word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
