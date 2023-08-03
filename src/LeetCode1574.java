import java.util.Map;

public class LeetCode1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        int right = length - 1;
        while (right > 0 && arr[right] > arr[right - 1]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }

        int ans = arr.length + 1;

        for (int left = 0; left == 0 || arr[left] > arr[left + 1]; left++) {
            while (right < length && arr[right] < arr[left]) {
                right++;
            }
            ans = Math.min(ans, length - right - left);
        }
        return ans;
    }

}
