
/* LEETCODE #684 */

/*

In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

*/


class Solution {

  /*
  Credits to https://www.geeksforgeeks.org/union-find/
  for how to detect cycles in an undirected graph
  */

  public int[] findRedundantConnection(int[][] edges) {

    // use a disjoint set to detect cycles in the graph
    int parent[] = new int[edges.length+1];

    for (int i=1; i<=edges.length; ++i) {
      parent[i]=-1;
    }

    int[] pair = new int[2];
    for (int i = 0; i < edges.length; ++i) {
      int x = find(parent, edges[i][0]);
      int y = find(parent, edges[i][1]);

      // cycle detected - order pair (u,v) where u < v
      if (x == y) {
        int smaller = edges[i][0] > edges[i][1] ? edges[i][1] : edges[i][0];
        int larger = edges[i][0] > edges[i][1] ? edges[i][0] : edges[i][1];
        pair[0] = smaller;
        pair[1] = larger;
      }
      // join the sets
      else {
        union(parent, x, y);
      }

    }

    return pair;
  }

  // join the two sets x and y contained in
  void union(int parent[], int x, int y) {
    parent[xset] = yset;
  }

  // find the set i is contained in
  int find(int parent[], int i) {
    if (parent[i] == -1)
    return i;
    return find(parent, parent[i]);
  }

}
