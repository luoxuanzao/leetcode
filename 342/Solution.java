class Solution {
    /**
     * 判断一个数是不是4的幂
     *
     * @param num
     * @return
     */
    //最笨的方法循环除以4
    //也可以用log2算 看结果是不是偶数
    //这里用位运算
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        //先判断是否是 2 的幂
        if ((num & num - 1) != 0)
            return false;
        //如果与运算之后是本身则是 4 的幂
        if ((num & 0x55555555) == num)
            return true;
        return false;
    }
}