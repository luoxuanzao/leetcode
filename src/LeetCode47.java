import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] vis;

    int[] nums;


    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>());
        return result;
    }

    public void backtrack(ArrayList<Integer> list) {
        if (list.size() == vis.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }

            vis[i] = true;
            list.add(nums[i]);
            backtrack(list);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
