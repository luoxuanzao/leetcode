import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * 输出1到n的数字 如果是3的倍数输出Fizz 如果是5的倍数输出Buzz
     * 如果同时是三的倍数 五的倍数 输出fizzbuzz
     *
     * 先用String数组存再转化成list 比 直接用list.add更高效
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        int index = 0;
        for (int k = 1; k <= n; k++) {
            if (k % 3 == 0 && k % 5 == 0) {
                result[index++] = "FizzBuzz";
            } else if (k % 3 == 0) {
                result[index++] = "Fizz";
            } else if (k % 5 == 0) {
                result[index++] = "Buzz";
            } else {
                result[index++] = String.valueOf(k);
            }
        }
        return Arrays.asList(result);
    }
}