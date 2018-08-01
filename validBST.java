
/* LEETCODE #98 */

/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
  public boolean isValidBST(TreeNode root) {
    return isBST(root, null, null);
  }

  boolean isBST(TreeNode root, Integer min, Integer max) {

    if (root == null) {
      return true;
    }

    // ensure node is greater than min
    if (min != null && root.val <= min) {
      return false;
    }
    // ensure node is less than max
    if (max != null && root.val >= max) {
      return false;
    }

    // left children must be less than root and right must be greater than root
    return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);



  }

}
