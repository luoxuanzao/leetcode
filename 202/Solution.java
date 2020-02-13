class Solution {
    /**
     * 判断一个数字是不是快乐数
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
     * 如果可以变为 1，那么这个数就是快乐数。
     *
     *
     * 思路 用双指针打破循环 当快慢指针相同时 有可能是 经过了循环 也有可能是 算到了1
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow=n;
        int fast=bitSqar(n);
        do{
            slow=bitSqar(slow);
            fast=bitSqar(fast);
            fast=bitSqar(fast);
        }while (slow!=fast);
        return slow==1;
    }
    public int bitSqar(int n){
        int result=0;
        int bit=0;
        while (n>0){
            bit=n%10;
            result=result+bit*bit;
            n=n/10;
        }
        return result;
    }

}