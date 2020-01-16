
import java.util.*;

class Solution {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 最大二叉树
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
         TreeNode root;
         if(nums.length==0)return null;
         else {
             int Max=0;
             int index=0;
            for(int i=0;i<nums.length;i++){
                if(Max<nums[i]){
                    Max=nums[i];
                    index=i;
                }
            }
            root=new TreeNode(Max);
            //传数组加 form to会快一点
            root.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
            root.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
         }
         return root;
    }

}
