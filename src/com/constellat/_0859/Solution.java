package com.constellat._0859;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        boolean isRepeat = false;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                isRepeat = true;
            }
            map.put(s.charAt(i), 1);
            if (s.charAt(i) != goal.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return isRepeat;
        }
        if (list.size() != 2) {
            return false;
        }
        int i = list.get(0);
        int j = list.get(1);
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }
}