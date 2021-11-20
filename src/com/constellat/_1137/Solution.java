package com.constellat._1137;

class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 3] + array[i - 2] + array[i - 1];
        }
        return array[n];
    }
}