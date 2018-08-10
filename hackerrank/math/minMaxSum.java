
/* HACKERRANK MIN MAX SUM */

/*

Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the miniMaxSum function below.
  static void miniMaxSum(int[] arr) {

    Arrays.sort(arr);
    long min = 0;
    long max = 0;

    for (int i = 0; i < 4; i++) {
      min += arr[i];
    }
    System.out.print(min + " ");
    for (int i = arr.length-1; i > arr.length-1- 4; i--) {
      max += arr[i];
    }
    System.out.println(max);

    return;


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[] arr = new int[5];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < 5; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    miniMaxSum(arr);

    scanner.close();
  }
}
