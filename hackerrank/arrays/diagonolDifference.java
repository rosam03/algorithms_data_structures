
/* HACKERRANK DIAGONOL DIFFERENCE */

/*

Given a square matrix, calculate the absolute difference between the sums of its diagonals.

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the diagonalDifference function below.
  static int diagonalDifference(int[][] arr) {

    int leftSum = 0;
    int rightSum = 0;

    // perfect square, so same num cols as rows
    // track left idx and increment by 1 on each row to get left diagnol
    // track right idx starting from last col and sub by
    // 1 on each row to get right diagnol
    int leftIdx = 0;
    int rightIdx = arr.length - 1;

    for (int row = 0; row < arr.length; row++)  {
      leftSum += arr[row][leftIdx];
      rightSum += arr[row][rightIdx];
      leftIdx++;
      rightIdx--;
    }

    return Math.abs(leftSum - rightSum);


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < n; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }

    int result = diagonalDifference(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
