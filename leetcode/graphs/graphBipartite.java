
/* LEETCODE #785 */

class Solution {

  /*
   * APPROACH: Use BFS and graph coloring to check if nodes neighbors have the same color,
   * if a neighbor has not been visited, assign it the opposite color of the visited node
  */

  public boolean isBipartite(int[][] graph) {

    // use coloring to keep track of the nodes states
    int[] color = new int[graph.length];
    // -1 (unvisited), 0 (yellow), 1 (red)
    for (int i = 0; i < graph.length; i++) {
      color[i] = -1;
    }

    // use BFS to search unvisited nodes and different clusters since graph is not connected
    for (int i = 0; i < graph.length; i++) {

      if (color[i] == -1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
          int node = queue.remove();
          // ensure visited nodes neighbors have different color than the visited node
          for (int y = 0; y < graph[node].length; y++) {
            if (color[graph[node][y]] == -1) {
              color[graph[node][y]] = 1 - color[node];
              queue.add(graph[node][y]);
            }
            else if (color[node] == color[graph[node][y]]) {
              return false;
            }
          }
        }

      }

    }

    // if we reach this point no adjacent nodes/neighbors have same color
    return true;
  }

}
