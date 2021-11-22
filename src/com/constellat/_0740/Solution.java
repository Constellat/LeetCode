package com.constellat._0740;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] array = new int[10001];
        for (int i = 0; i < 10001; i++) {
            array[i] = 0;
        }
        for (int num : nums) {
            array[num]++;
        }
        int[] result = new int[10001];
        result[0] = 0 * array[0];
        result[1] = 1 * array[1];
        for (int i = 2; i < 10001; i++) {
            result[i] = Math.max(result[i - 2] + i * array[i], result[i - 1]);
        }
        return result[10000];
    }
}