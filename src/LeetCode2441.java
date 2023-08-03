import java.util.HashSet;
import java.util.Set;

public class LeetCode2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = -1;
        for (int num : nums) {
            set.add(num);
            if (set.contains(-num)) {
                result = Math.max(result, num > 0 ? num : -num);
            }
        }
        return result;
    }
}
