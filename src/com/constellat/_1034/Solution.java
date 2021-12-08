package com.constellat._1034;

import java.util.HashSet;
import java.util.Set;

class Solution {

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (null == obj || !(obj instanceof Point)) {
                return false;
            }
            Point point = (Point) obj;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return row;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (row >= grid.length || row < 0) {
            return grid;
        }
        if (col >= grid[0].length || col < 0) {
            return grid;
        }
        Set<Point> set = new HashSet<>();
        final int changedColor = grid[row][col];
        calcChangePoint(grid, row, col, changedColor, set);
        set.forEach(point -> {
            if (set.contains(new Point(point.row - 1, point.col)) &&
                    set.contains(new Point(point.row, point.col - 1)) &&
                    set.contains(new Point(point.row, point.col + 1)) &&
                    set.contains(new Point(point.row + 1, point.col))) {
                return;
            }
            grid[point.row][point.col] = color;
        });
        return grid;
    }

    public void calcChangePoint(int[][] grid, int row, int col, int changedColor, Set<Point> set) {
        if (row < 0 || row >= grid.length) {
            return;
        }
        if (col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] != changedColor) {
            return;
        }
        Point point = new Point(row, col);
        if (set.contains(point)) {
            return;
        }
        // 颜色相同，记录
        set.add(point);
        calcChangePoint(grid, row - 1, col, changedColor, set);
        calcChangePoint(grid, row, col - 1, changedColor, set);
        calcChangePoint(grid, row, col + 1, changedColor, set);
        calcChangePoint(grid, row + 1, col, changedColor, set);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[3][];
        grid[0] = new int[]{1, 1, 1};
        grid[1] = new int[]{1, 1, 1};
        grid[2] = new int[]{1, 1, 1};
        int[][] result = solution.colorBorder(grid, 1, 1, 2);
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                System.out.println(result[i][i1]);
            }
        }
    }
}