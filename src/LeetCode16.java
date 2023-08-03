import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    int temp = right - 1;
                    while (temp > left && nums[temp] == nums[temp + 1]) {
                        temp--;
                    }

                    right = temp;
                } else {
                    int temp = left + 1;
                    while (temp < right && nums[temp] == nums[temp - 1]) {
                        temp++;
                    }

                    left = temp;
                }
            }
        }
        return result;
    }
}
