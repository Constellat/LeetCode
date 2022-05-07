package com.constellat._0475;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length) {
                if (heaters[j] >= houses[i] && (j == 0 || heaters[j - 1] <= houses[i])) {
                    if (j == 0) {
                        max = Math.max(max, heaters[j] - houses[i]);
                    } else {
                        int temp = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
                        max = Math.max(max, temp);
                    }
                    break;
                }
                j++;
            }
            if (j == heaters.length) {
                max = Math.max(max, houses[i] - heaters[j - 1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1, 3, 5}, new int[]{3}));
        System.out.println(solution.findRadius(new int[]{1, 3, 5}, new int[]{1}));
        System.out.println(solution.findRadius(new int[]{1, 3, 5}, new int[]{5}));
    }
}