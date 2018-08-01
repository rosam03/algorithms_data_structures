
/* LEETCODE #257 */

/*

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

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

  private ArrayList<String> pathList;

  public List<String> binaryTreePaths(TreeNode root) {
    pathList = new ArrayList<String>();
    findPaths(root, "");
    return pathList;
  }

  void findPaths(TreeNode node, String path) {

    if (node == null) {
      return;
    }

    path += Integer.toString(node.val);

    // reached leaf
    if (node.left == null && node.right == null) {
      pathList.add(path);
      return;
    }

    // node has at least one child
    findPaths(node.left, path + "->");
    findPaths(node.right, path + "->");

    return;

  }
}
