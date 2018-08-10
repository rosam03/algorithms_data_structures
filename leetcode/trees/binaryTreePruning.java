
/* LEETCODE #814 */

/*

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

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

  public TreeNode pruneTree(TreeNode root) {

    if (isOneFound(root)) {
      return root;
    }

    return null;
  }

  boolean isOneFound(TreeNode node) {

    if (node == null) {
      return false;
    }

    boolean leftStays = isOneFound(node.left);
    boolean rightStays = isOneFound(node.right);

    if (leftStays && rightStays) {
      return true;
    }

    if (leftStays) {
      node.right = null;
      return true;
    }
    else if (rightStays) {
      node.left = null;
      return true;
    }

    else if (node.val == 1) {
      node.left = null;
      node.right = null;
      return true;
    }

    return false;

  }

}
