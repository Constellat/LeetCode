package com.constellat._0174;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int yLength = dungeon.length;
        int xLength = yLength > 0 ? dungeon[0].length : 0;
        if (xLength == 0) {
            return 1;
        }
        int[][] array = new int[yLength][xLength];
        array[yLength - 1][xLength - 1] = Math.max(1 - dungeon[yLength - 1][xLength - 1], 1);

        for (int xIndex = xLength - 2; xIndex >= 0; xIndex--) {
            array[yLength - 1][xIndex] = Math.max(1, array[yLength - 1][xIndex + 1] - dungeon[yLength - 1][xIndex]);
        }
        for (int yIndex = yLength - 2; yIndex >= 0; yIndex--) {
            array[yIndex][xLength - 1] = Math.max(1, array[yIndex + 1][xLength - 1] - dungeon[yIndex][xLength - 1]);
        }
        for (int xIndex = xLength - 2; xIndex >= 0; xIndex--) {
            for (int yIndex = yLength - 2; yIndex >= 0; yIndex--) {
                array[yIndex][xIndex] = Math.min(array[yIndex + 1][xIndex], array[yIndex][xIndex + 1]);
                array[yIndex][xIndex] = Math.max(1, array[yIndex][xIndex] - dungeon[yIndex][xIndex]);
            }
        }

        return array[0][0];
    }
}