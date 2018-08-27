
/* HACKERRANK FREQUENCY QUERIES */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

  static HashMap<Integer, Integer> map = new HashMap<>();
  static HashMap<Integer, Integer> freq=new HashMap<>();

  // Complete the freqQuery function below.
  static List<Integer> freqQuery(List<int[]> queries) {

    List<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < queries.size(); i++) {
      int val = queries.get(i)[1];

      switch(queries.get(i)[0]) {
        case 1:
          insert(val);
          break;
        case 2:
          remove(val);
          break;
        default:
          if (find(val)) {
            result.add(1);
          }
          else {
            result.add(0);
          }
          break;
      }
    }

    return result;
  }

  static void insert(int val) {

    int fr = 0;
    // decrement current freq
    fr = map.getOrDefault(val, 0);
    freq.put(fr, freq.getOrDefault(fr, 0)-1);
    map.put(val, map.getOrDefault(val, 0)+1);
    // increment new freq
    fr=map.getOrDefault(val, 0);
    freq.put(fr, freq.getOrDefault(fr, 0)+1);

  }

  static void remove(int val) {

    int fr = 0;
    if (map.containsKey(val)) {
      // decrement curr freq count
      fr=map.getOrDefault(val, 0);
      freq.put(fr, freq.getOrDefault(fr, 0)-1);
      map.put(val, map.get(val)-1);

      // remove element from map if no occurrences remain
      fr=map.getOrDefault(val, 0);
      if (fr < 1) {
        map.remove(val);
        return;
      }

      // increment new freq count
      freq.put(fr, freq.getOrDefault(fr, 0)+1);
    }

  }

  static boolean find(int val) {

    if (freq.getOrDefault(val, 0) > 0) {
      return true;
    }
    else {
      return false;
    }

  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
        ans.stream()
        .map(Object::toString)
        .collect(joining("\n"))
        + "\n");
      }
    }
  }
}
