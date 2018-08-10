
/* HACKERRANK CAMEL CASE */

/*

Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given , print the number of words in  on a new line.

For example, . There are  words in the string.

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the camelcase function below.
  static int camelcase(String s) {

    int count = 0;

    // search the string for frequency of uppercase letters

    // each uppercase letter represents a word, except for the first

    count++;

    char[] arr = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(arr[i]) ) {
        count++;
      }
    }

    return count;


  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    int result = camelcase(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
