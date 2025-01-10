package Amazon;

public class RottingOrganes {
    public int orangesRotting(int[][] grid) {
        int mnts = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    mark(grid, i, j, mnts);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
                mnts = Math.max(mnts, grid[i][j]);
            }
        }
        return mnts - 2;
    }

    private void mark(int[][] grid, int i, int j, int mnts) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0
                || (grid[i][j] > 1 && grid[i][j] < mnts))
            return;
        grid[i][j] = mnts;
        mark(grid, i + 1, j, mnts + 1);
        mark(grid, i - 1, j, mnts + 1);
        mark(grid, i, j + 1, mnts + 1);
        mark(grid, i, j - 1, mnts + 1);
    }
}
