import java.util.HashSet;
import java.util.Set;

class LeetCode805 {
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int sum = 0;
        int n = nums.length;
        int m = n / 2;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    total += nums[j];
                }
            }
            if(total == 0){
                return true;
            }
            set.add(total);
        }

        int rSum = 0;
        for (int i = m; i < n; i++) {
            rSum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int total = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    total += nums[j];
                }
            }
            if (total == 0 || (total != rSum && set.contains(-total))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode805 test = new LeetCode805();
        System.out.println(test.splitArraySameAverage(new int[]{3, 1}));
    }

}