
/* HACKERRANK WEIGHTED UNIFORM STRING */

/*

A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are  to  from  to  as shown below:


The weight of a string is the sum of the weights of all the string's characters.

A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not.

Given a string, , let  be the set of weights for all possible uniform contiguous substrings of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the weightedUniformStrings function below.
  static String[] weightedUniformStrings(String s, int[] queries) {

    String[] result = new String[queries.length];

    Map<Integer, Character> map = new HashMap<Integer, Character>();

    // 1) get all uniform cont. substrings in s
    char[] arr = s.toCharArray();
    char lastChar = '0';
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      // 2) for each substr, calc weight and store in a map with key weight -> val            uniform substring to allow for constant lookups
      if (arr[i] == lastChar) {
        count++;
      }
      else {
        lastChar = arr[i];
        count = 1;
      }
      map.put((lastChar-'a'+1)*count, lastChar);
    }


    // 3) for each query, if query[i] in map, add to ret arr

    for (int i = 0; i < queries.length; i++) {
      if (map.containsKey(queries[i])) {
        result[i] = "Yes";
      }
      else {
        result[i] = "No";
      }
    }

    return result;




  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    int queriesCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] queries = new int[queriesCount];

    for (int i = 0; i < queriesCount; i++) {
      int queriesItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      queries[i] = queriesItem;
    }

    String[] result = weightedUniformStrings(s, queries);

    for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(result[i]);

      if (i != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
