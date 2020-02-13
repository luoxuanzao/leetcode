public class Solution {
    // you need to treat n as an unsigned value

    /**
     * 给一个无符号整数 判断用2进制表示时有多少个1
     *使用位运算 不断与只有1为是1的数做与运算&如果结果不为0则表示该位是1
     * 左移操作<<=n 表示左移n位
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int check = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & check) != 0) {
                count++;
            }
            check <<= 1;
        }
        return count;
    }
}