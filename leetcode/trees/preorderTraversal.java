
/* LEETCODE #144 */

/*

Given a binary tree, return the preorder traversal of its nodes' values.

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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preorder = new ArrayList<Integer>();
        // preorder = root, left, right
        preorderTraversal(root, preorder);

        return preorder;  
    }

    void preorderTraversal(TreeNode root, List<Integer> preorder) {
        if (root == null) return;

        preorder.add(root.val);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);

    }


}
