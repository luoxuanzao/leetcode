import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxuezhuo
 */
public class interview1705 {


    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        // 前缀和
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + (array[i].charAt(0) >> 6 & 1) * 2 - 1;
        }
        // 符合要求的子数组 [begin,end)
        int begin = 0, end = 0;
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i <= n; ++i) {
            int j = first.getOrDefault(s[i], -1);
            // 首次遇到 s[i]
            if (j < 0) {
                first.put(s[i], i);
            }
            // 更长的子数组
            else if (i - j > end - begin) {
                begin = j;
                end = i;
            }
        }

        String[] sub = new String[end - begin];
        System.arraycopy(array, begin, sub, 0, sub.length);
        return sub;
    }
}


