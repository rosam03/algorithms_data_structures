
/* LEETCODE #563 */

/*

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.



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

  private int result = 0;

  public int findTilt(TreeNode root) {

    if (root == null) {
      return 0;
    }
  
    sumSubTree(root);

    return result;
  }

  int sumSubTree(TreeNode node) {

    if ( node == null ) {
      return 0;
    }

    int l = sumSubTree(node.left);
    int r = sumSubTree(node.right);

    result+= Math.abs(l - r);

    return node.val + l + r;
  }

}
