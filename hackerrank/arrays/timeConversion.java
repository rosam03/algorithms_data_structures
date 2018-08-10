
/* HACKERRANK TIME CONVERSION */

/*

Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  /*
  * Complete the timeConversion function below.
  */
  static String timeConversion(String s) {
    /*
    * Write your code here.
    */

    // determine whether time is AM or PM

    if (s.contains("AM")) {
      // remove am
      s = s.substring(0, s.length()-2);

      String hour = s.substring(0, 2);
      // if 12am -> change hour to 00
      if (Integer.valueOf(hour) == 12) {
        return "00" + s.substring(2);
      }

      // any other am, no need to change hour
      return s;
    }
    else {
      s = s.substring(0, s.length()-2);
      String hour = s.substring(0, 2);
      // if 12pm -> no need to change
      if (Integer.valueOf(hour) == 12) {
        return s;
      }

      // if other pm, change hour to 12 + hour
      int newHour = Integer.valueOf(hour) + 12;

      return String.valueOf(newHour) + s.substring(2);
    }

  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scan.nextLine();

    String result = timeConversion(s);

    bw.write(result);
    bw.newLine();

    bw.close();
  }
}
