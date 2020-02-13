class Solution {
    /**
     * 移动0 把所有的0移动到数组的末尾 其他数字的相对顺序保持不变
     * 可以把非0的移动到前面 维护一个计数器计算0的个数
     * 把非零的个数移动到 i-count的地方
     * 最后把后count个数全部置为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count=0;//记录0的个数
        for(int i=0;i<nums.length;i++){
        if(nums[i]==0)count++;
        else {
            nums[i-count]=nums[i];
        }

    }
        for(int j=nums.length-count;j<nums.length;j++ ){
            nums[j]=0;
        }
    }

    public static void main(String[] args) {
        Solution test=new Solution();
        test.moveZeroes(new int[]{0,1,0,3,1,2});
    }
}