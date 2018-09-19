
/* LEETCODE #172 */

class Solution {

  public int trailingZeroes(int n) {

    // count factors of 5 in each power of 5 contained in n
    // since increasing powers contribute additional trailing 0's
    // 5 contributes 1, 25 contributes 2, 125 contributes 3..
    int factors = 0;

    while (n > 1) {
      factors += n/5;
      n = n/5; // check additional powers
    }

    return factors;
  }



  /* Less optimal: For each multiple of 5 in n, count the number of factors of 5
  * in it, and take the sum of all factors
  /*

  public int trailingZeroes(int n) {

    // for each number 1-n, count how many factors of 5 are in it
    int factors = 0;
    // optimization: increment by 5 so we only count factors for multiples of 5
    for (int i = 5; i <= n; i = i+5) {
      factors += factorsof5(i);
    }

    return factors;
  }

  int factorsof5(int num) {

    // multiple of 5
    if (num % 5 == 0) {
      int count = 1;
      num = num/5;
      // counts total # of factors of 5
      while (num % 5 == 0) {
        count++;
        // check for additional factors of 5 in powers of 5 (ie 25, 125)
        num = num/5;
      }
      return count;
    }

    return 0;
  }

  */

}
