import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1704 {
    Set<Character> letter;

    public boolean halvesAreAlike(String s) {
        char[] letters = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        letter = new HashSet();
        for (char c : letters) {
            letter.add(c);
        }
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        return count(s1) == count(s2);
    }

    public int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter.contains(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
        ArrayList<String> a = new ArrayList<>();
        a.add(null);
        System.out.println(a.get(0).length());
    }
}
