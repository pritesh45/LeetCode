class DSU {
    vector<int> parent;
    int maxSize; 

public:
    DSU(int n) {
        parent.resize(n, -1);
        maxSize = 1; // Correctly initializing the member variable
    }

    int find(int x) {
        if (parent[x] < 0) 
            return x;
        return parent[x] = find(parent[x]); // Path compression
    }

    void unite(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) 
            return;

        if (parent[parentX] <= parent[parentY]) { // Union by size
            parent[parentX] += parent[parentY];
            parent[parentY] = parentX;
            maxSize = max(maxSize, abs(parent[parentX]));
        } else {
            parent[parentY] += parent[parentX];
            parent[parentX] = parentY;
            maxSize = max(maxSize, abs(parent[parentY]));
        }
    }

    int getMax() {
        return maxSize;
    }
};

class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<int> d = {0, -1, 0, 1, 0};  // Movement in 4 directions
        DSU dsu(rows * cols);
        bool isLand = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    isLand = true;
                    int cellNo = i * cols + j;

                    for (int k = 0; k < 4; k++) {
                        int ni = i + d[k];
                        int nj = j + d[k + 1];  // Corrected nj calculation

                        if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && grid[ni][nj] == 1) {
                            int nId = ni * cols + nj;
                            dsu.unite(cellNo, nId);
                        }
                    }
                }
            }
        }
        return isLand ? dsu.getMax() : 0;
    }
};
