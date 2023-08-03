public class LeetCode1785 {

    public int minElements(int[] nums, int limit, int goal) {
        int s = sum(nums);
        int gap = Math.abs(goal - s);
        int result = gap / Math.abs(limit);
        int mod = gap % Math.abs(limit);
        result = mod == 0 ? result : result + 1;
        return result;
    }

    public int sum(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result += i;
        }
        return result;
    }
}
