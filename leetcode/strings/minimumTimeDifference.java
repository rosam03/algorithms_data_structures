
/* LEETCODE #539 */

class Solution {

  /*
    APPROACH 1 (BRUTE FORCE)
    // O(n^2) - SEE BOTTOM OF CODE
    // Compare each element to the rest in the list
    // and calculate the time difference, store the min

    APPROACH 2
    // O(nlogn + n) time, O(n) space
    // Put the times in a in new list and sort the list, then
    // iterate through list and compare adjacent elements for min time

  */


  public int findMinDifference(List<String> timePoints) {

    // APPROACH 3
    // O(n) time, O(1) space
    // Calculate time as a function of minutes and put in a boolean array
    // which indicates that time is a valid one (its in the given list)
    // Iterate through boolean array (will be sorted by minutes) and compare
    // adjacent elements (that are valid, set to TRUE).

    boolean[] times = new boolean[24*60];

    for (int i = 0; i < timePoints.size(); i++) {
      String[] time1 = timePoints.get(i).split(":");
      int h1 = Integer.parseInt(time1[0])*60;
      int m1 = Integer.parseInt(time1[1]);
      // if already true, 0 min difference, quick exit
      if (times[h1+m1] == true) {
        return 0;
      }
      times[h1+m1] = true;
    }

    int first = Integer.MAX_VALUE;
    int prev = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < times.length; i++) {

      if (times[i] == true) {
        if (first == Integer.MAX_VALUE) {
          first = i;
        }
        else {
          min = Math.min(i - prev, min);
        }
        prev = i;
      }

    }

    min = Math.min(min, 24*60-prev + first);

    return min;

  }
}


// TIME LIMIT EXCEEDED: O(N^2) BRUTE FORCE SOLUTION

// class Solution {
//     public int findMinDifference(List<String> timePoints) {

//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < timePoints.size(); i++) {
//             for (int y = i+1; y < timePoints.size(); y++) {
//                 int temp = getTimeDifference(timePoints.get(i), timePoints.get(y));
//                 if (temp < min) {
//                     min = temp;
//                 }
//             }
//         }

//         return min;
//     }

//     int getTimeDifference(String t1, String t2) {

//         String[] time1 = t1.split(":");
//         String[] time2 = t2.split(":");

//         int h1 = Integer.parseInt(time1[0])*60;
//         int m1 = Integer.parseInt(time1[1]);
//         int h2 = Integer.parseInt(time2[0])*60;
//         int m2 = Integer.parseInt(time2[1]);

//         int larger = h1+m1 > h2+m2 ? h1+m1 : h2+m2;
//         int smaller = h1+m1 > h2+m2 ? h2+m2 : h1+m1;
//         System.out.println(larger);

//         int diffBack = Math.abs(larger - smaller);
//         System.out.println(diffBack);
//         // carying into next day
//         int diffForward = Math.abs(24*60 - larger + smaller);
//         System.out.println(diffForward);

//         return Math.min(diffBack, diffForward);
//     }
// }
