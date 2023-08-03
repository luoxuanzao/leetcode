import java.util.Arrays;

public class LeetCode1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < n) {
                result[i * 2] = nums[i];
            } else {
                result[(i - n) * 2 + 1] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1470 t = new LeetCode1470();
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        System.out.println(Arrays.toString(t.shuffle(nums,3)));
    }
}
