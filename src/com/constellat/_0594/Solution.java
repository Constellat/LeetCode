package com.constellat._0594;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
            int temp = map.get(num);
            int countOfBefore = 0;
            int countOfAfter = 0;
            if (!map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                continue;
            }
            if (map.containsKey(num - 1)) {
                countOfBefore = map.get(num - 1);
            }
            if (map.containsKey(num + 1)) {
                countOfAfter = map.get(num + 1);
            }
            temp += Math.max(countOfAfter, countOfBefore);
            max = Math.max(max, temp);
        }
        return max;
    }
}