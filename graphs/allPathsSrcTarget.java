
/* LEETCODE #797 */

/*

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

*/

class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    // use DFS to find all paths
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    // check if each edge of source has paths to N
    for (int i = 0; i < graph[0].length; i ++) {
      List<Integer> path = new ArrayList<Integer>();
      path.add(0);
      path.add(graph[0][i]);
      // found node N-1
      if (graph[0][i] == graph.length - 1) {
        result.add(path);
        continue;
      }

      findPaths(graph[0][i], graph[graph[0][i]].length, graph, path, result);
    }

    return result;
  }

  public void findPaths(int curNode, int edgesRemaining, int[][] graph, List<Integer> curPath ,List<List<Integer>> result) {

    // base case - reached end of edges for curNode
    if (edgesRemaining == 0) {
      return;
    }

    // if immediate path, add to list
    int i;
    for (i=0; i < graph[curNode].length; i++) {
      if (graph[curNode][i] == graph.length-1) {
        List<Integer> path = new ArrayList<>(curPath);
        path.add(graph[curNode][i]);
        result.add(path);
      }
      else{
        List<Integer> path = new ArrayList<>(curPath);
        path.add(graph[curNode][i]);
        findPaths(graph[curNode][i], graph[graph[curNode][i]].length, graph, path, result);
      }
    }

  }

}
