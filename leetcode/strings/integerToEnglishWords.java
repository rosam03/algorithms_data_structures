
/* LEETCODE #273 */

class Solution {

  // index these with num-1
  String[] ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
  String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
  String[] postfix = {"", "Thousand","Million","Billion"};

  
  public String numberToWords(int num) {

    if (num == 0) {
      return "Zero";
    }

    String res = "";
    int i = 0;

    while (num > 0) {

      if (num%1000 > 0) {
        // get rightmost three digits and convert to string
        String threeStr = convertToString(num%1000);
        // append postfix as necessary based on i
        // i = 0 none, thousand, million, billion
        String post = postfix[i];
        res = threeStr + post + " " + res;
      }

      num /= 1000;
      i++;
    }

    return res.trim();
  }

  String convertToString(int num) {

    if (num == 0) {
      return "";
    }

    String res = "";

    if (num < 20) {
      res = ones[num-1] + " ";
    }
    else if (num < 100) {
      res = tens[num/10-2] + " " + convertToString(num%10);
    }
    else {
      res = ones[num/100-1] + " Hundred "+ convertToString(num%100);
    }

    return res;
  }

}
