import java.util.Arrays;

/**
 * @author liuxuezhuo
 */
public class LeetCode1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums[nums.length - 1]; i++) {
            int index = 0;
            while (nums[index] < i){
                index++;
            }
            if(nums.length - index == i){
                return i;
            }else if(nums.length - index < i){
                break;
            }
        }
        return -1;
    }
}
