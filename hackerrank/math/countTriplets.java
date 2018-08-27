
/* HACKERRANK COUNT TRIPLETS */


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

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {


    long result = 0;

    Map<Long, Long> first = new HashMap<>();
    Map<Long, Long> second = new HashMap<>();

    for (Long n : arr) {
      // number may make a double or triple if it is a factor of r
      if (n % r == 0) {
        // find if this number makes a double or triple for the previous number
        Long prev = n / r;
        Long triple = second.get(prev);
        if (triple != null) result += triple;

        Long dble = first.get(prev);
        if (dble != null) second.put(n, second.getOrDefault(n, 0L) + dble);
      }
      first.put(n, first.getOrDefault(n, 0L) + 1);
    }
    return result;


  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nr[0]);

    long r = Long.parseLong(nr[1]);

    List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
    .map(Long::parseLong)
    .collect(toList());

    long ans = countTriplets(arr, r);

    bufferedWriter.write(String.valueOf(ans));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
