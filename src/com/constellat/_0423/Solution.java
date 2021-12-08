package com.constellat._0423;

import java.util.HashMap;

class Solution {
    public String originalDigits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int[] number = new int[10];
        number[0] = map.getOrDefault('z',0);
        number[2] = map.getOrDefault('w',0);
        number[4] = map.getOrDefault('u',0);
        number[6] = map.getOrDefault('x',0);
        number[8] = map.getOrDefault('g',0);
        number[3] = map.getOrDefault('h',0) - number[8];
        number[5] = map.getOrDefault('f',0) - number[4];
        number[7] = map.getOrDefault('v',0) - number[5];
        number[1] = map.getOrDefault('o',0) - number[2] - number[4] - number[0];
        number[9] = map.getOrDefault('i',0) - number[8] - number[6] - number[5];

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < number.length; index++) {
            int value = number[index];
            for (int i = 0; i < value; i++) {
                result.append(index);
            }
        }
        return result.toString();
    }
}