
/* HACKERRANK MINIMUM SWAPS 2 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {

    // if arr[i] != i + 1, its in wrong pos, swap with element at arr[arr[i]-1]
    int[] copy = arr.clone();
    int swaps = 0;
    for (int i = 0; i < copy.length; i++) {
      // may have value greater than array length,
      // in that case it should remain unswapped and at the end
      if (copy[i] != i + 1 && copy[i] < copy.length) {
        swaps++;
        swap(i, copy);
        // reset i to 0 to check from beginning again
        i = 0;
      }
    }

    return swaps;


  }

  static void swap(int i, int[] copy) {
    int temp = copy[i];
    int swapIndex = temp-1;
    copy[i] = copy[swapIndex];
    copy[swapIndex] = temp;
    return;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
