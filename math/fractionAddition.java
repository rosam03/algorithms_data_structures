
/* LEETCODE #592 */

/*

Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

*/

class Solution {


  /*when adding/subtracting fractions, unsimplified result Den = denom1*denom2
  unsimplified result Nom = nom1*denom2 + nom2*denom1
  simplify the Nom and Den by finding their greatest common factor
  and dividing both by it for final result
  */

  public String fractionAddition(String expression) {

    String[] values = expression.split("(?=[-+])");
    int[][] fractions = new int[values.length][2];
    int denom = 1;
    int num = 0;

    for (int i = 0; i < values.length; i++) {
      int slash = values[i].indexOf("/");
      if (values[i].contains("-")) {
        fractions[i][0] = 0-Integer.parseInt(values[i].substring(1,slash));
        fractions[i][1] = Integer.parseInt(values[i].substring(slash+1));

      }
      else if (values[i].contains("+")) {
        fractions[i][0] = Integer.parseInt(values[i].substring(1,slash));
        fractions[i][1] = Integer.parseInt(values[i].substring(slash+1));
      }
      else {
        fractions[i][0] = Integer.parseInt(values[i].substring(0,slash));
        fractions[i][1] = Integer.parseInt(values[i].substring(slash+1));

      }
      num = num*fractions[i][1] + fractions[i][0]*denom;
      denom = denom*fractions[i][1];
    }

    // take absolute to preserve the sign
    int result = Math.abs(gcd(num, denom));

    int n = num/result;
    int d = denom/result;

    // convert back to string
    return Integer.toString(n) + "/" + Integer.toString(d);
  }


  int gcd(int a, int b) {

    if (b == 0) {
      return a;
    }
    return gcd(b, a%b);
  }




}
