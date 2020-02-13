import java.util.HashSet;

class Solution {
    /**
     * 找出只出现一次的数字 （其余数字都会出现两次）
     *
     * 方法一 用集合没出现就加进去 出现过就删掉
     *
     * 方法二 用异或 一个数字与自己异或为0
     *          0与一个数字异或结果是本身
     * @param nums
     * @return
     */
//    public int singleNumber(int[] nums) {
//        HashSet set=new HashSet();
//        for(int i : nums){
//            if(!set.contains(i)){
//                set.add(i);
//            }else{
//                set.remove(i);
//            }
//        }
//        return (Integer) set.toArray()[0];
//    }
    public int singleNumber(int[] nums){
        int ans=0;
        for(int i:nums){
            ans=ans^i;
        }
        return ans;
    }
}