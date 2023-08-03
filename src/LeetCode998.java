public class LeetCode998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }else{
            root.right = insertIntoMaxTree(root.right,val);
            return root;
        }
    }
}
