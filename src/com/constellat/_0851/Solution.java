package com.constellat._0851;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Set<Integer>> list = new ArrayList<>(quiet.length);
        for (int i = 0; i < quiet.length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            list.add(set);
        }
        for (int i = 0; i < richer.length; i++) {
            int[] ints = richer[i];
            int from = ints[0];
            int to = ints[1];
            Set<Integer> set = list.get(to);
            set.addAll(list.get(from));
        }
        for (int i = richer.length - 1; i >= 0; i--) {
            int[] ints = richer[i];
            int from = ints[0];
            int to = ints[1];
            Set<Integer> set = list.get(to);
            set.addAll(list.get(from));
        }
        int[] result = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            Set<Integer> set = list.get(i);
            int min = Integer.MAX_VALUE;
            for (Integer integer : set) {
                if (quiet[integer] < min) {
                    min = quiet[integer];
                    result[i] = integer;
                }
            }
        }
        return result;
    }
}