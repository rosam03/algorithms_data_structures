
/* LEETCODE #887 */

/*

On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Now we view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.

*/



class Solution {
  public int projectionArea(int[][] grid) {

    int xy = 0;
    int xz = 0;
    int yz = 0;

    for (int i = 0; i < grid.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] >= max) {
          max = grid[i][j];
        }

        if (grid[i][j] >0) {
          xy++;
        }
      }
      xz += max;
    }

    int[] largest = new int[grid.length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] > largest[j]) {
          largest[j] = grid[i][j];
        }
      }
    }

    for (int i = 0; i < largest.length; i++) {
      yz += largest[i];
    }

    return yz+xz+xy;

  }
  
}
