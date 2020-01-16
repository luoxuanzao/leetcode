
import java.util.*;

class Solution {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
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
            root.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
            root.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
         }
         return root;
    }
    
}
