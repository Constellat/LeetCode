package com.constellat._0509;

class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}