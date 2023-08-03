import java.util.ArrayList;
import java.util.List;

public class LeetCode792 {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        List<Integer>[] list = new List[26];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                res--;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (list[c - 'a'].isEmpty() || (list[c - 'a'].get(list[c - 'a'].size() - 1) <= p)) {
                    res--;
                    break;
                }
                p = binarySearch(list[c - 'a'], p);
            }

        }

        return count;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return list.get(left);
    }

    public boolean isSubString(String s, String target) {
        int pointS = 0;
        int pointT = 0;
        while (pointT < target.length()) {
            while (pointS < s.length() && s.charAt(pointS) != target.charAt(pointT)) {
                pointS++;
            }
            if (pointS >= s.length()) {
                break;
            }
            pointT++;
            pointS++;
        }
        return pointT == target.length();
    }

    public static void main(String[] args) {
        LeetCode792 test = new LeetCode792();
        System.out.println(test.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
