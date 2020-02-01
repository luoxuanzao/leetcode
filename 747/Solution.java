class Solution{
	/**
	  *	数组中的最大数至少是其他数字的两倍 如果没有就返回-1 有就返回index；
	**/
	public int dominantIndex(int[] nums) {
        //一次扫描找出最大值以及索引
		int index=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
		//再扫描一次判断是否满足条件
        for(int j=0;j<nums.length;j++){
            if(j==index)continue;
            else{
                if(nums[j]*2>max)return-1;
            }
        }
        return index;
    }
}