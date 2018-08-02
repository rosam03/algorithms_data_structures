
/* LEETCODE #547 */

/*

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

*/


class Solution {

  public int findCircleNum(int[][] M) {

    // track which have been visited to avoid cycles
    boolean[] visited = new boolean[M.length];

    int groups = 0;
    for (int i = 0; i < M.length; i++) {
      // if a friend has not yet been visited, must be part of new group
      if (!visited[i]) {
        groups++;
        // search all connected friends
        dfs(i, M, visited);
      }
    }

    return groups;
  }

  void dfs(int y, int[][] friends, boolean[] visited) {

    visited[y] = true;

    for (int i = 0; i < friends.length; i++) {
      if (friends[y][i] == 1 && !visited[i]) {
        dfs(i, friends, visited);
      }
    }

    return;

  }
}
