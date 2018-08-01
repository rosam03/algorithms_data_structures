
/* LEETCODE #326 */

/*

Given an integer, write a function to determine if it is a power of three.

*/

class Solution {
  public boolean isPowerOfThree(int n) {

    if ( n < 1) {
      return false;
    }

    while (n % 3 == 0) {
      n /= 3;
    }

    if (n == 1) {
      return true;
    }

    return false;

  }
}
