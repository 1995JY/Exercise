package count.number98;


public class Solution {
    Long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<pre){
            return false;
        }
        pre=(long)root.val;

       return isValidBST(root.right);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }