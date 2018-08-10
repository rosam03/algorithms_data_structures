
/* HACKERRANK SHERLOCK ANAGRAMS */

/*

Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string which are anagrams of each other.

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {

    // 1) generate all sunstrings of size 0-s.length()
    // 2) for each substring size i, generate a char freq count
    // 3) store each char freq count array in an arraylist
    // 4) when generated all substrings of size i, iter through list
    // 5) if any list elements ==, count ++
    // 6) after iteratinging through list, clear list since diff size substrings wont be anagrams
    // repeat for remaining substrings

    Map<String, Integer> map = new HashMap<String, Integer>();

    int count = 0;

    for (int subSize = 1; subSize < s.length(); subSize++) {
      for(int i =0; i + subSize -1 < s.length(); i++) {
        char[] sub = s.substring(i, i+subSize).toCharArray();
        Arrays.sort(sub);
        String substr = String.valueOf(sub);

        if (map.containsKey(substr)) {
          map.put(substr, map.get(substr) + 1);
        }
        else {
          map.put(substr, 1);
        }

      }

    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {

      count += (entry.getValue()*(entry.getValue()-1)) / 2;


    }

    return count;

    // time: O(s.length()^2), space: O(s.length)


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = sherlockAndAnagrams(s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
