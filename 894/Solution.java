
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
class Solution {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    Map<Integer, List<TreeNode>> memo = new HashMap();//用于记录 不同重复计算

    /**
     * 所有可能的满二叉树 ，每个结点的度只能为0或2
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    //++x 与  x++不影响循环 ++x更高效 更节省空间
                    //x是左树的个数
                    int y = N - 1 - x;//y是右树的个数

                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            //左子树与右子树组合
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
