import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class LeetCode1630 {
    int[] num;

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        num = nums;
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(check(l[i], r[i]));
        }
        return result;
    }

    public boolean check(int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
            set.add(num[i]);
        }
        if ((max - min) % (end - start) != 0) {
            return false;
        }

        int d = (max - min) / (end - start);
        for (int i = 0; i <= (end - start); i++) {
            if (!set.contains(num[start] + i * d)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode1630 main = new LeetCode1630();
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        main.checkArithmeticSubarrays(nums, l, r);

        AtomicReference atomicReference = new AtomicReference(main);

    }
}
