
/* HACKERRANK FRIEND CIRCLE QUERIES */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the maxCircle function below.
  static int[] maxCircle(int[][] queries) {

    int max = 0;
    Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
    Map<Integer, Integer> size = new HashMap<Integer, Integer>();
    int[] result = new int[queries.length];

    for(int i = 0; i < queries.length; i++) {

      int a = queries[i][0];
      int b = queries[i][1];

      if (!parent.containsKey(a)) {
        parent.put(a, -1);
        size.put(a, 1);
      }
      if (!parent.containsKey(b)) {
        parent.put(b, -1);
        size.put(b, 1);
      }

      int parentA = find(a, parent);
      int parentB = find(b, parent);
      if (parentA != parentB) {
        // update size of parent set

        // create balanced sets - smaller set gets added to larger set
        int newSize = size.get(parentA) + size.get(parentB);
        if (size.get(parentA) < size.get(parentB)) {
          size.put(parentB, newSize);
          parent.put(parentA, parentB);
        }
        else {
          size.put(parentA, newSize);
          parent.put(parentB, parentA);
        }


        // a and b will have same size by this point
        max = max > newSize? max: newSize;
      }

      result[i] = max;
    }

    return result;
  }

  /* this is only called on elements that exist */
  static int find(int a, Map<Integer, Integer> parent) {

    if ((parent.get(a)).equals(-1)) {
      return a;
    }
    return find(parent.get(a), parent);
  }

  static void join(Map<Integer, Integer> parent, int pA, int pB) {
    parent.put(pB, pA);
    return;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[][] queries = new int[q][2];

    for (int i = 0; i < q; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 2; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    int[] ans = maxCircle(queries);

    for (int i = 0; i < ans.length; i++) {
      bufferedWriter.write(String.valueOf(ans[i]));

      if (i != ans.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
