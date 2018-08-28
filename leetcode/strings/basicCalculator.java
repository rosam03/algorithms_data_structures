
/* LEETCODE #224 */

class Solution {

  int i;

  public int calculate(String s) {
    i = 0;
    return helper(s);
  }

  int helper(String s) {
    int num = 0;
    int res = 0;
    int sign = 1; // first value is positive given expression contains non-negative ints

    while(i < s.length()) {
      char c = s.charAt(i);
      switch(c) {
        case ' ' :
          i++;
          break;
        case '+' :
          res = res + sign * num;
          num=0;
          sign = 1;
          i++;
          break;
        case '-' :
          res = res + sign * num;
          num=0;
          sign = -1;
          i++;
          break;
        case '(' :
          // recursively calculate result in parenthesis
          i++; // pre incremenet i to avoid infinite recursion
          res = res + sign * helper(s);
          break;
        case ')' :
          // return back the value inside parenthesis
          res = res + sign * num;
          i++;
          return res;
        default :
        // number may span multiple digits
          int n = c-'0';
          num = num * 10 + n;
          i++;
          break;
      }
    }
    return res + sign*num; // account for last value remaining
  }

}
