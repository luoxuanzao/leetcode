class Solution {
    /**
     * 计算质数  计算小于n的质数的个数
     * 用厄拉多塞筛选法 从2开始 如果是质数就把n以内所有这个质数的倍数全部筛选掉
     * 剩下的就是质数的个数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++) {
            if(!isPrime[i]){
                for(int j=2;j*i<n;j++){
                    isPrime[j*i]=true;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        System.out.println(test.countPrimes(4));
    }
}