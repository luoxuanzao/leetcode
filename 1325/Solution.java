
import javax.management.StringValueExp;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * 删除特定值的叶节点
     * 深度优先就完事
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return DFS(root,target);
    }
    public TreeNode DFS (TreeNode root,int target){
        if(root==null)return null;
        if(root.right==null&&root.left==null){
            if(root.val==target){
                return null;
            }
            else return root;
        }else {//不是叶节点
            root.right=DFS(root.right,target);
            root.left=DFS(root.left,target);
            if(root.left==null&&root.right==null&&root.val==target){
                return null;
            }else {
                return root;
            }

        }
    }


}