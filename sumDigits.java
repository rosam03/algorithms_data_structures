
/* LEETCODE # 258 */

/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

*/

class Solution {

  public int addDigits(int num) {

    if (num < 10 ) { return num;}

    int result = num;
    int sum = 0;

    while (result != 0) {
      sum += result % 10;
      result = result / 10;
    }

    if (sum >= 10) {
      sum = addDigits(sum);
    }

    return sum;
  }

}
