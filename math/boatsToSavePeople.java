
/* LEETCODE #885 */

/*

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

*/

class Solution {

  /*
    Time complexity: O(n), Space complexity: O(n)

    Optimize:
    To reduce space complexity, will need to make a time-space tradeoff.
    Can sort the people list, and match up the greatest weights with the
    lightest weights by indexing from the left and right side of sorted list.
    For those that fit in boat, increment the left and right index pointers

    Optimized time complexity: depending on sorting algorithm, java sort is O(nlogn)
    Optimized space complexity: O(1)
  */

  public int numRescueBoats(int[] people, int limit) {

    Map<Integer, Integer> weights = new HashMap<Integer, Integer>();
    for (int i = 0; i < people.length; i++) {

      if (weights.containsKey(people[i])) {
        weights.put(people[i], weights.get(people[i]) + 1);
      }
      else {
        weights.put(people[i], 1);
      }

    }


    int boats = 0;

    for (int i =0 ; i < people.length; i++) {

      // hasnt gone on boat yet
      if (weights.get(people[i]) > 0) {
        boats++;
        int myW = people[i];
        weights.put(myW, weights.get(people[i])-1);

        while (limit - myW > 0) {

          if (weights.containsKey(limit-myW) && weights.get(limit-myW) > 0) {
            int otherW = weights.get(limit-myW);
            weights.put(limit-myW, otherW-1);
            myW += limit-myW;
          }
          else {
            myW++;
          }

        }

      }

    }

    return boats;
  }
}
