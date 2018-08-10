
/* LEETCODE #46 */

/*

Given a collection of distinct integers, return all possible permutations.

*/


class Solution {
  public List<List<Integer>> permute(int[] nums) {

    if (nums.length == 0 || nums == null) {
      return new ArrayList<List<Integer>>();
    }

    // integers left to be permuted
    List remainder = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      remainder.add(nums[i]);
    }

    List permutations = new ArrayList<List<Integer>>();
    // track the set of the current permutation
    List setList = new ArrayList<Integer>();

    permute(remainder, permutations, setList);

    return permutations;
  }

  void permute(List<Integer> remainder, List<List<Integer>> permutations, List<Integer> setList) {

    if (remainder.size() == 0) {
      List<Integer> copy = new ArrayList<Integer>(setList);
      permutations.add(copy);
      return;
    }

    // permutations can be obtained by taking a single integer of those remaining,
    // and appending the permutation of the remaining integers
    for (int i = 0; i < remainder.size(); i++) {
      setList.add(remainder.get(i));
      List remaining = new ArrayList<Integer>();

      for (int y = 0; y < remainder.size(); y++ ) {
        if (y != i) {
          remaining.add(remainder.get(y));
        }
      }
      permute(remaining, permutations, setList);
      setList.remove(remainder.get(i));
    }

    return;
  }
}
