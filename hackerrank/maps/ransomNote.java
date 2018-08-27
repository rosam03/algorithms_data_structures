
/* HACKERRANK RANSOM NOTE */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {

    HashMap<String, Integer> wordsNeeded = new HashMap<String, Integer>();

    // put all words in note into a map with frequency
    for (int i = 0; i < note.length; i++) {
      if (wordsNeeded.containsKey(note[i])) {
        wordsNeeded.put(note[i], wordsNeeded.get(note[i])+1);
      }
      else {
        wordsNeeded.put(note[i], 1);
      }
    }

    // for each word in magazine, if key in map and val > 0, subtract 1 from map and incr count
    int found = 0;
    for (int i = 0; i < magazine.length; i++) {

      if (wordsNeeded.containsKey(magazine[i]) && wordsNeeded.get(magazine[i]) > 0) {
        wordsNeeded.put(magazine[i], wordsNeeded.get(magazine[i])-1);
        found++;
      }

      // found all words needed for note
      if (found == note.length) {
        System.out.println("Yes");
        return;
      }

    }

    if (found != note.length) {
      System.out.println("No");
      return;
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
