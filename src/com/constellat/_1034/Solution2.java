package com.constellat._1034;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        int originalColor = grid[row][col];
        visited[row][col] = true;
        dfs(grid, row, col, visited, borders, originalColor);
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0], y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length, n = grid[0].length;
        boolean isBorder = false;
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x, ny = direc[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[5][];
        grid[0] = new int[]{1, 1, 1, 1, 1};
        grid[1] = new int[]{1, 2, 2, 2, 1};
        grid[2] = new int[]{1, 2, 2, 2, 1};
        grid[3] = new int[]{1, 2, 2, 2, 1};
        grid[4] = new int[]{1, 1, 1, 1, 1};
        int[][] result = solution.colorBorder(grid, 2, 2, 3);
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                System.out.print(result[i][i1] + " ");
            }
            System.out.println();
        }
    }
}
