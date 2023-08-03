import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxuezhuo
 */
public class LeetCode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int minIndex = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int gap = Math.abs(arr[i] - x);
            if (gap < minGap) {
                minGap = gap;
                minIndex = i;
            }
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        int count = 1;
        result.add(arr[minIndex]);
        while (count < k) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x) || (Math.abs(arr[left] - x) == Math.abs(arr[right] - x))) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } else if (right < arr.length) {
                result.add(arr[right]);
                right++;
            } else {
                break;
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,1,3,5,6,7,8,8};
        LeetCode658 test = new LeetCode658();
        test.findClosestElements(arr,2,2);
    }


}
