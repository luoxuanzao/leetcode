
import java.util.*;

class Solution {
    boolean[] iscal;
    boolean[] valid;

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        iscal=new boolean[nums.length];
        valid=new boolean[nums.length];
        return jump(nums,0);
//        return greedy(nums);
    }
    public boolean jump(int[]nums,int index){
        //暴力求解 加 存储已经算好的
        if(iscal[index]){//已经计算过存起来的
            return valid[index];
        }else {
            if (index == nums.length - 1) {
                iscal[index]=true;
                valid[index]=true;
                return true;
            }
            int further = Math.min(index + nums[index], nums.length - 1);
            for (int i = further; i >= index+1; --i) {
                if (jump(nums, i)) {
                    iscal[index]=true;
                    valid[index]=true;
                    return true;
                }
            }
            iscal[index]=true;
            valid[index]=false;
            return false;
        }

    }
    //贪心算法
    //从后往前找 position代表最左边的可以跳到末尾的点
    //只要再之前的加上步数能超过position就说明可以到达position 然后就更新position
    public boolean greedy(int[] nums){
        int position=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=position){
                position=i;
            }
        }

        return position==0;
    }
}
