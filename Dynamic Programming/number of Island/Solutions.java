import java.util.*;
class Solutions {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0'; // mark visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid1 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("Number of islands (grid1): " + sol.numIslands(grid1)); // Output: 3

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("Number of islands (grid2): " + sol.numIslands(grid2)); // Output: 1

        char[][] grid3 = {
            {'0','0','0'},
            {'0','0','0'},
            {'0','0','0'}
        };
        System.out.println("Number of islands (grid3): " + sol.numIslands(grid3)); // Output: 0
    }

}
