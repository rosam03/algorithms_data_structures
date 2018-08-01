
/* LEETCODE #236 */

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.

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

  /* Note: this is the brute force solution. We can optimize this using the knowledge
      that if the nodes are found on different sides (left/right) then we know the
      root is the lca. Since we are given that both nodes will exist in the tree,
      if the nodes are on same side, then the lca is the first node found.
      With the optimized solution, we need not store a list of paths, we just pass
      up the node that equals p or q. If the left and right subtrees pass up values,
      the lca is the current node, so it passes itself up.
  */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    ArrayList<TreeNode> pathp = new ArrayList<TreeNode>();
    ArrayList<TreeNode> pathq = new ArrayList<TreeNode>();

    if (p.val == root.val || q.val == root.val) {
      return root;
    }

    foundpath(root, p, pathp);
    foundpath(root, q, pathq);

    // compare path lengths
    int difference = Math.abs(pathp.size() - pathq.size());

    // shift the longer path so we can compare the common path
    if (difference > 0) {
      if (pathp.size() > pathq.size()) {
        shift(difference, pathp);
      }
      else {
        shift(difference, pathq);
      }

    }

    int i;
    for (i = 0; i < pathp.size(); i++) {
      if (pathp.get(i).val == pathq.get(i).val) {
        return pathp.get(i);
      }
    }

    return null;



  }

  void shift(int difference, ArrayList<TreeNode> path) {

    while (difference > 0) {
      path.remove(0);
      difference--;
    }

    return;

  }

  boolean foundpath(TreeNode root, TreeNode find, ArrayList<TreeNode> path) {

    if (root == null) {
      return false;
    }

    if (root.val == find.val) {
      path.add(root);
      return true;
    }

    if (foundpath(root.left, find, path)) {
      path.add(root);
      return true;
    }
    else if (foundpath(root.right, find, path)) {
      path.add(root);
      return true;
    }

    return false;
  }

}
