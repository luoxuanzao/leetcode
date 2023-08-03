public class LeetCode6224 {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k != 0) {
                result[i] = 0;
            } else {
                result[i] = nums[i] / k;
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length; j++) {
                if (result[j] == 0) {
                    break;
                }
                if (checkNum(i, j, result)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkNum(int start, int end, int[] nums) {
        if (start == end && nums[start] == 1) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (getGCD(nums[i], nums[j]) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode6224 test = new LeetCode6224();
        int[] nums = new int[]{9, 3, 1, 2, 6, 3};

        System.out.println(test.subarrayGCD(nums, 3));
    }
}
