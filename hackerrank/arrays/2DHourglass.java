
/* HACKERRANK 2D - DS */

/*

See problem description for diagrams

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {

    if (arr.length == 0 || arr == null) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    // hour glass exists if 3 remaining colums and rows left
    for (int row = 0; row <= arr.length-3; row++) {
      for (int col = 0; col <= arr[row].length-3; col++) {
        int sum = getSum(row, col, arr);
        System.out.println(sum);
        max = Math.max(max, sum);
      }
    }

    return max;
  }

  static int getSum(int row, int col, int[][] arr) {

    int sum = 0;
    sum += arr[row][col];
    sum += arr[row][col+1];
    sum += arr[row][col+2];
    sum += arr[row+1][col+1];
    sum += arr[row+2][col];
    sum += arr[row+2][col+1];
    sum += arr[row+2][col+2];

    return sum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = hourglassSum(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
