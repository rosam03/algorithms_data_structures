
/* LEETCODE #110 */


/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

*/


/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/
class Solution {

  private final int ERROR_CODE = -5;

  public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != ERROR_CODE;
  }

  private int checkHeight(TreeNode root) {

    // height of null node is -1
    if (root == null) {
      return -1;
    }

    int lHeight = checkHeight(root.left);
    int rHeight = checkHeight(root.right);

    if (lHeight == ERROR_CODE || rHeight == ERROR_CODE) {
      return ERROR_CODE;
    }

    // not balanced if height diff by more than 1
    if (Math.abs(lHeight - rHeight) > 1) {
      return ERROR_CODE;
    }

    // compare against subtree with greater height
    return 1 + Math.max(lHeight, rHeight);
  }
  
}
