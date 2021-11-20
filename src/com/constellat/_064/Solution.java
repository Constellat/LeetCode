package com.constellat._064;

class Solution {
    public int minPathSum(int[][] grid) {
        int yLength = grid.length;
        int xLength = yLength > 0 ? grid[0].length : 0;
        if (xLength == 0) {
            return 0;
        }
        int[][] array = new int[yLength][xLength];
        array[0][0] = grid[0][0];
        for (int xIndex = 1; xIndex < xLength; xIndex++) {
            array[0][xIndex] = array[0][xIndex - 1] + grid[0][xIndex];
        }
        for (int yIndex = 1; yIndex < yLength; yIndex++) {
            array[yIndex][0] = array[yIndex - 1][0] + grid[yIndex][0];
        }

        for (int xIndex = 1; xIndex < xLength; xIndex++) {
            for (int yIndex = 1; yIndex < yLength; yIndex++) {
                array[yIndex][xIndex] = Math.min(array[yIndex - 1][xIndex], array[yIndex][xIndex - 1]);
                array[yIndex][xIndex] = array[yIndex][xIndex] + grid[yIndex][xIndex];
            }
        }
        return array[yLength - 1][xLength - 1];
    }
}