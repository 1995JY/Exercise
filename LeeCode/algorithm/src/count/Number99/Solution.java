package count.Number99;
/*
给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
1.如何确定这两个节点的位置
2.保存这两个节点的值
3.重新遍历树，给节点赋值
 */
class Solution {
    public void recoverTree(TreeNode root) {


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