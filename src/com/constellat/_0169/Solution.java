package com.constellat._0169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > length / 2) {
                return num;
            }
        }
        return 0;
    }
}