class Solution {
    /**
     * 打家劫舍  不能偷相邻两家的钱 如何能偷最多的钱
     *
     * 动态规划
     * 状态转移方程 f(x) = max (f(x-1),f(x-2)+x)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int pre=0;
        int current=0;
        for(int i:nums){
            int temp=current;
            current=Math.max(pre+i,current);
            pre=current;
        }
        return current;
    }
}