
/* HACKERRANK ANAGRAMS */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the anagram function below.
  static int anagram(String s) {

    // not anagrams if diff length
    if (s.length() %2 != 0) {
      return -1;
    }

    int size = 26; // ascii 'z'-'a'

    // char freq count arrays initialized to 0
    int[] freqFirst = new int[size];
    int[] freqSecond = new int[size];

    // get both halves of string
    String a = s.substring(0, s.length()/2);
    String b = s.substring(s.length()/2);

    // length of halves are same
    int len = a.length();

    // count char frequencies
    for (int i = 0; i < len; i++) {
      freqFirst[a.toCharArray()[i] - 'a']++;
      freqSecond[b.toCharArray()[i] - 'a']++;
    }

    int diff = 0;

    // check differences in char frequencies
    for (int y = 0; y < size; y++) {
      if (freqFirst[y] != freqSecond[y]) {
        diff += Math.abs(freqFirst[y] - freqSecond[y]);
      }
    }

    return diff/2;


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = anagram(s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
