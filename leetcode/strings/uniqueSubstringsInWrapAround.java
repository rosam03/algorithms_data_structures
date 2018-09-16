
/* LEETCODE #467 */

/*

Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

*/

/*

INITIAL APPROACH (memory limit exceeded):
1) get all unique substrings of p
2) determine how many of the substrings are contiguous using (arr[i] - 'a')%26 == (arr[i-1] - 'a' + 1)%26)

*/

class Solution {
  public int findSubstringInWraproundString(String p) {

    // ensure p len > 0
    if (p == null || p.length() < 1) {
      return 0;
    }

    if (p.length() == 1) {
      return 1;
    }

    // track length of longest contiguous substring ending in each character
    // the length of longest ending in each character represents the number
    // of contiguous substrings ending in that char, thus adding to the final count


    // ie: "abcd" is contiguous and ends with d, has length 4 representing substrings "acbd", "cbd", "bd", "d"
    // "ab" in "abcd" has length 2, representing contiguous substrings ending with b, "ab", "b"
    // "a" has length 1, representing "a" which is contiguous
    // the resulting count is the sum of the counts

    int[] count = new int[26]; // for asci chars a-z
    int contiguous = 0;
    char[] arr = p.toCharArray();

    for (int i = 0; i < arr.length; i++) {

      // contiguous if this char is the next in asci (with wrap arounds from z to a)
      if (i > 0 && (arr[i] - 'a')%26 == (arr[i-1] - 'a' + 1)%26) {
        contiguous++;
      }
      else {
        contiguous = 1;
      }
      count[arr[i]-'a'] = Math.max(contiguous, count[arr[i]-'a']);
    }

    // sum the contiguous substrings
    int result = 0;
    for (int i = 0; i < count.length; i++) {
      result += count[i];
    }

    return result;
  }

}
