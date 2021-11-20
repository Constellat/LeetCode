package com.constellat._0746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] array = new int[cost.length + 1];
        array[0] = 0;
        array[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            array[i] = Math.min(array[i - 1] + cost[i - 1], array[i - 2] + cost[i - 2]);
        }
        return array[cost.length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{1,0,0,1}));
    }
}