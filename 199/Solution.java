import java.util.ArrayList;
import java.util.List;

class Solution{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int deep=-1;
    List<Integer>result=new ArrayList<>();

    /**
     * 二叉树的右视图
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return null;
        help(root,0);
        return result;
    }
    public void help(TreeNode root ,int current){
        if(root==null)return;
        if(current>deep){
            result.add(root.val);
            deep++;
        }
        help(root.right,current+1);
        help(root.left,current+1);
    }

}