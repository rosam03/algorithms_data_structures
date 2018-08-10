
/* LEETCODE #415 */

/*

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/


class Solution {
    public String addStrings(String num1, String num2) {

        // since we may append digits numerous times, using SB is more efficient
        StringBuilder result = new StringBuilder();

        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int carry = 0;

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        // iterate as long as there are remaining digits or carry
        while (len1 >= 0 || len2 >= 0 || carry >= 1) {

            int dig1 = 0;
            int dig2 = 0;

            // substract with the asci value of '0' to get integer value of digits
            if (len1 >= 0) {
                dig1 = arr1[len1] - '0';
            }
            if (len2 >= 0) {
                dig2 = arr2[len2] - '0';
            }

            int sum = (dig1 + dig2 + carry) % 10;
            carry = (dig1 + dig2 + carry) / 10;

             // append each result to a string, note that final will be in reverse order
            result.append(sum);

            len1--;
            len2--;

        }

        return result.reverse().toString();

    }
}
