class Solution {
    /**
     * 买卖股票的最好时机  只能买一次卖一次
     * 暴力法 两层循环
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int pre=0;
//        for(int i=0;i<prices.length;i++){
//            for(int j=i;j<prices.length;j++){
//                pre=Math.max(pre,prices[j]-prices[i]);
//            }
//        }
//        return pre;
//    }

    /**
     * 动态规划
     * 从前往后遍历 f(x) = max (f(x-1),x-min)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int min=Integer.MAX_VALUE;
        int maxpro=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else {
                maxpro=Math.max(maxpro,prices[i]-min);
            }
        }
        return maxpro;
    }

}