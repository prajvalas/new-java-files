public class NumberOfIslands {
    public static void main(String[] args) {
        // char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0',
        // '1', '0' },
        // { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        char[][] grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
        System.out.println("Number of islands are : " + numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);

    }

    // public static int isIsland(char[][] grid, int i, int j, boolean start) {

    // if (grid[i][j] == '1') {
    // grid[i][j] = '2';

    // if (i - 1 > -1 && grid[i - 1][j] == '1') {
    // isIsland(grid, i - 1, j, false);
    // }
    // if (j - 1 > -1 && grid[i][j - 1] == '1') {
    // isIsland(grid, i, j - 1, false);
    // }
    // if (i + 1 < grid.length && grid[i + 1][j] == '1') {
    // isIsland(grid, i + 1, j, false);
    // }
    // if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
    // isIsland(grid, i, j + 1, false);
    // }
    // if (start == true) {
    // count++;
    // start = false;
    // }

    // }

    // if (grid[i][j] == '0') {
    // grid[i][j] = '4';
    // while ((i + 1 < grid.length && grid[i + 1][j] != '1')
    // || (j + 1 < grid[0].length && grid[i][j + 1] != '1')) {
    // if (i + 1 < grid.length) {
    // i++;
    // } else if (j + 1 < grid[0].length) {
    // j++;
    // }
    // }
    // if (grid[i][j] == '1') {
    // isIsland(grid, i, j, true);
    // }

    // else if (grid[i][j] == '1') {
    // isIsland(grid, i, j, true);
    // }
    // } else {
    // while ((i + 1 < grid.length && grid[i + 1][j] != '1')
    // || (j + 1 < grid[0].length && grid[i][j + 1] != '1')) {
    // if (i + 1 < grid.length) {
    // i++;
    // } else if (j + 1 < grid[0].length) {
    // j++;
    // }

    // }
    // if (grid[i][j] == '1') {
    // isIsland(grid, i, j, true);
    // }

    // else if (grid[i][j] == '1') {
    // isIsland(grid, i, j, true);
    // }
    // }
    // return count;
    // }
}
