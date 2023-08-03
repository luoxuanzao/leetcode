import java.util.Arrays;

public class LeetCode2576 {
    //    public int maxNumOfMarkedIndices(int[] nums) {
//        Arrays.sort(nums);
//
//        // 最笨的办法
//        int right = nums.length / 2;
//
//        while (right < nums.length) {
//            int index = 0;
//            while (index < right && right + index < nums.length) {
//                if (nums[index] * 2 > nums[right + index]) {
//                    break;
//                }
//                index++;
//            }
//            if (right + index == nums.length) {
//                return index * 2;
//            }
//            right += 1;
//        }
//
//        return 0;
//    }
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = (nums.length + 1) / 2;
        int result = 0;
        while (left < nums.length / 2 && right < nums.length) {
            if (nums[left] * 2 <= nums[right]) {
                result+=2;
                right++;
                left++;
            }else {
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LeetCode2576 test = new LeetCode2576();
//        System.out.println(test.maxNumOfMarkedIndices(new int[]{7, 6, 8}));
        System.out.println(test.maxNumOfMarkedIndices(new int[]{3, 5, 2,4}));
    }
}
