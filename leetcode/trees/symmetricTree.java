
/* LEETCODE #101 */

/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric.
But the following [1,2,2,null,3,null,3] is not.

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
  public boolean isSymmetric(TreeNode root) {

    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }

    return isSymmetrical(root.left, root.right);

  }

  boolean isSymmetrical(TreeNode left, TreeNode right) {

    // if one is null, both must be null
    if (left == null || right == null) {
      return left == right;
    }

    if (left.val == right.val) {
      return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    return false;


  }
}
