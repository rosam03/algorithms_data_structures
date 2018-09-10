
/* LEETCODE #654 */

/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }


    // recursively build left and right subtrees
    TreeNode helper(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int index = findMax(nums, start, end);

        TreeNode root = new TreeNode(nums[index]);

        root.left = helper(nums, start, index-1);
        root.right = helper(nums, index+1, end);

        return root;
    }

    // return index of maximum integer in nums between start and end, inclusive
    int findMax(int[] nums, int start, int end) {

        int max = start;
        for (int i = start+1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        return max;
    }

}
