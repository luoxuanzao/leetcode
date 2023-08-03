import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode2584 {
    public int findValidSplit(int[] nums) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int[] store = new int[nums.length];
        Arrays.fill(store, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    store[i] = j;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean valid = true;
            for (Pair<Integer, Integer> pair : pairs) {
                if (i >= pair.getKey() && i < pair.getValue()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        LeetCode2584 test = new LeetCode2584();
        test.findValidSplit(nums);
    }
}
