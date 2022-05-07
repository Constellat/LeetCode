package com.constellat._0807;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        if (N <= 0) {
            return 0;
        }
        int[] maxRows = new int[N];
        int[] maxColumns = new int[N];

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                if (grid[row][column] > maxRows[row]) {
                    maxRows[row] = grid[row][column];
                }
                if (grid[row][column] > maxColumns[column]) {
                    maxColumns[column] = grid[row][column];
                }
            }
        }

        int result = 0;
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                int target = Math.min(maxRows[row], maxColumns[column]);
                result += target - grid[row][column];
            }
        }
        return result;
    }
}