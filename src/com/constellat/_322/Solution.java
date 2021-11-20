package com.constellat._322;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            array[i] = -1;
        }
        array[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int index = 0; index < coins.length; index++) {
                if (i < coins[index]) {
                    continue;
                }
                if (array[i - coins[index]] != -1) {
                    min = Math.min(min, array[i - coins[index]]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                array[i] = min + 1;
            }
        }
        return array[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{186,419,83,408}, 6249));
    }
}