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
     * 根据先序遍历 构造匹配的二叉搜索树
     * 确定好 左子节点的范围 右子节点的范围就好了
     * @param
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList();
        if(root==null){
            return result;
        }else{
            List<String>l=binaryTreePaths(root.left);
            List<String> r=binaryTreePaths(root.right);
            for(String s:binaryTreePaths(root.left)){
                result.add(root.val+"->"+s);
            }
            for(String t:binaryTreePaths(root.right)){
                result.add(root.val+"->"+t);
            }
            if(l.size()==0&&r.size()==0){
                result.add(root.val+"");
            }
            return result;
        }
    }


 

}