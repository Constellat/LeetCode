package com.constellat._0406;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        int[][] peoples = new int[6][2];
        peoples[0] = new int[]{7, 0};
        peoples[1] = new int[]{4, 4};
        peoples[2] = new int[]{7, 1};
        peoples[3] = new int[]{5, 0};
        peoples[4] = new int[]{6, 1};
        peoples[5] = new int[]{5, 2};
        int[][] results = reconstructQueue(peoples);
        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] peoples) {
        Arrays.sort(peoples, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        int[][] results = new int[peoples.length][];
        for (int i = 0; i < peoples.length; i++) {
            results[i] = new int[2];
        }
        for (int i = 0; i < peoples.length; i++) {
            int loc = peoples[i][1];
            if (loc > results.length) {
                return null;
            } else {
                int length = i;
                for (; length > loc; length--) {
                    results[length][0] = results[length - 1][0];
                    results[length][1] = results[length - 1][1];
                }
                results[length][0] = peoples[i][0];
                results[length][1] = loc;
            }
        }
        return results;
    }
}