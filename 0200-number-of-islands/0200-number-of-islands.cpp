class Solution {
public:
    void dfs(vector<vector<char>>& grid, int i, int j) {
        // Base case: out of bounds or water ('0')
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited (change '1' to '0')
        grid[i][j] = '0';

        // Visit all connected cells (left, right, up, down)
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        for(int i = 0; i < grid.size(); i++) {  // Corrected the condition
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == '1') {  // Found land
                    dfs(grid, i, j);  // Sink the island
                    res++;  // Increment the island count
                }
            }
        }
        return res;  // Return the number of islands
    }
};
