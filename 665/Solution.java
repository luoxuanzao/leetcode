class Solution {
    public boolean checkPossibility(int[] nums) {
        //如果长度小于三 一次肯定可以解决
        if(nums.length < 3){
            return true;
        }
        int count = 0;

        //1 3 2
        //2 3 1
        //3 3 2
        //2 3 2
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(count > 1){
                    break;
                }
                //第i个的前一个比后一个大就改后一个
                //第i个的前一个小于等于后一个就改第i个
                if(i-1 >=0&&nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
            }
        }
        return count <= 1;
    }
}

