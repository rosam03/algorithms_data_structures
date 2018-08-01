
/* LEETCODE */

/*

Given a binary tree with duplicates, find all the mode(s) (the most frequently occurred element) in the given tree.

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

    // track the max frequency
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {

        // map each value to its frequency
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        // store potentially multiple modes in list, size unknown
        ArrayList<Integer> modes = new ArrayList<Integer>();

        traverse(root, freq);


        // find the values that appear max times
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }

        // copy dynamic list back into array once size is known
        int[] modesarr = new int[modes.size()];
        for (int i =0; i < modes.size(); i ++) {
            modesarr[i] = modes.get(i);
        }

        return modesarr;

    }

    void traverse(TreeNode root, Map<Integer, Integer> freq) {

        if (root == null) {
            return;
        }

        // visit nodes inorder -> left, root, right
        traverse(root.left, freq);

        if (freq.get(root.val) == null) {
            freq.put(root.val, 1);
        }
        else {
            freq.put(root.val, freq.get(root.val)+1);
        }

        max = Math.max(freq.get(root.val), max);

        traverse(root.right, freq);

        return;

    }
}
