import java.util.*;

class DSU {
    private int[] parent;  // Array to store the parent of each element
    private int maxSize;   // Variable to store the maximum size of any component

    // Constructor: Initializes the parent array and maxSize
    public DSU(int n) {
        parent = new int[n];  // Initialize the parent array for n elements
        Arrays.fill(parent, -1);  // Initially, each element is its own parent, and the size is 1
        maxSize = 1;  // Initialize the maximum size of any component as 1
    }

    // Find the representative (root) of the set that contains element x
    public int find(int x) {
        if (parent[x] < 0)  // If parent[x] is negative, then x is the root of its set
            return x;
        return parent[x] = find(parent[x]);  // Path compression: flatten the tree for faster future lookups
    }

    // Unite the sets containing x and y. Use union by size to minimize tree depth.
    public void unite(int x, int y) {
        int parentX = find(x);  // Find the root of x
        int parentY = find(y);  // Find the root of y

        if (parentX == parentY)  // If both are already in the same set, no need to unite
            return;

        // Union by size: Attach the smaller set to the larger one
        if (parent[parentX] <= parent[parentY]) {
            parent[parentX] += parent[parentY];  // Increase the size of the root set
            parent[parentY] = parentX;  // Set parentX as the root of parentY
            maxSize = Math.max(maxSize, Math.abs(parent[parentX]));  // Update the max size if necessary
        } else {
            parent[parentY] += parent[parentX];  // Increase the size of the root set
            parent[parentX] = parentY;  // Set parentY as the root of parentX
            maxSize = Math.max(maxSize, Math.abs(parent[parentY]));  // Update the max size if necessary
        }
    }

    // Return the maximum size of any component in the DSU
    public int getMax() {
        return maxSize;
    }
}

class Solution {
    // Main function to find the maximum area of an island in a 2D grid
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;  // Number of rows in the grid
        int cols = grid[0].length;  // Number of columns in the grid
        int[] d = {0, -1, 0, 1, 0};  // Directions for moving up, left, down, right (4 directions)
        DSU dsu = new DSU(rows * cols);  // Create a DSU to manage connected components (islands)
        boolean isLand = false;  // Flag to check if we encounter any land cell (1)

        // Iterate over the entire grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {  // If the cell is land
                    isLand = true;  // Mark that we encountered land
                    int cellNo = i * cols + j;  // Unique identifier for the current cell

                    // Check all 4 neighboring cells (up, left, down, right)
                    for (int k = 0; k < 4; k++) {
                        int ni = i + d[k];  // Calculate the neighbor's row index
                        int nj = j + d[k + 1];  // Calculate the neighbor's column index

                        // Check if the neighbor is valid and also land
                        if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && grid[ni][nj] == 1) {
                            int nId = ni * cols + nj;  // Unique identifier for the neighboring cell
                            dsu.unite(cellNo, nId);  // Unite the current cell with the neighboring land cell
                        }
                    }
                }
            }
        }
        
        // If there was any land, return the maximum area of the island, else return 0
        return isLand ? dsu.getMax() : 0;
    }
}
