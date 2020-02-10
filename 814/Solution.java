import java.util.ArrayList;
import java.util.List;

class Solution {
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    /**
     * 二叉树剪枝
     * 如果子树中没有1 就把这个子树删除
     * @param
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)return null;
        root.right=pruneTree(root.right);
        root.left=pruneTree(root.left);
        if(root.right==null&&root.left==null&&root.val==0)return null;
        else return root;

    }



}