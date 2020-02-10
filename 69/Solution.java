class Solution {
    /**
     * 求一个数的平方根 用二分法
     *  right=mid-1; 要mid-1 不然会死循环
     *  二分法就是 while(left<right)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left=0;
        long right=x/2+1;
        long mid;
        while(left<right){
            mid=(left + right+1)/2;
            if(mid*mid==x)return (int)mid;
            if(mid*mid>x){
                right=mid-1;
                mid=(left+right+1)/2;
            }else {
                left=mid;
                mid=(left+right+1)/2;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        test.mySqrt(8);
    }
}