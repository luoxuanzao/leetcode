import java.util.HashMap;
import java.util.Map;

public class LeetCode1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return helper(a, b) || helper(b, a);
    }

    public boolean helper(String a, String b) {
        int n = a.length();
        int left = 0;
        int right = n - 1;

        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return checkLeft(a, left, right);
    }

    public boolean checkLeft(String a, int left, int right) {
        while (left < right && a.charAt(left) == a.charAt(right)) {
            left++;
            right--;
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        return left >= right;
    }
}
