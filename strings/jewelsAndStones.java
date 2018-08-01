
/* LEETCODE #771 */

/*

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

*/


class Solution {

  public int numJewelsInStones(String J, String S) {
    
    // null check and empty string
    if (J == null || S == null || J.length() == 0) {
      return 0;
    }

    // pre computation work: add all jewels to map
    Map<String, Integer> jewels = new HashMap<String, Integer>();
    for (int i = 0; i < J.length(); i++) {
      jewels.put(Character.toString(J.charAt(i)), 1);
    }

    // for each char in S, if in map, its also a jewel
    int count = 0;
    for (int i = 0; i < S.length(); i++) {
      if (jewels.containsKey((Character.toString(S.charAt(i))))) {
        count++;
      }
    }

    return count;
  }

}
