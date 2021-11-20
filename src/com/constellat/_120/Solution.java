package com.constellat._120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] array = new int[triangle.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        array[0] = triangle.get(0).get(0);
        for (int level = 1; level < triangle.size(); level++) {
            List<Integer> listOfLevel = triangle.get(level);
            int[] temp = array.clone();
            for (int i = 0; i < listOfLevel.size(); i++) {
                if (i == 0) {
                    temp[i] = array[i] + listOfLevel.get(i);
                } else if (i == listOfLevel.size() - 1) {
                    temp[i] = array[i - 1] + listOfLevel.get(i);
                } else {
                    temp[i] = Math.min(array[i - 1], array[i]);
                    temp[i] = temp[i] + listOfLevel.get(i);
                }
            }
            array = temp.clone();
        }
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = Math.min(min, i);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(-1));
        triangle.add(Arrays.asList(3, 2));
        triangle.add(Arrays.asList(-3, 1, -1));
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
    }
}