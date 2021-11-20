package com.constellat._22;

import java.util.*;

class Solution {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> resultList = new ArrayList<>();
        if (n == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }
        resultList.add(Collections.singletonList(""));
        resultList.add(Collections.singletonList("()"));
        for (int i = 2; i <= n; i++) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int j1 = i - 1 - j;
                List<String> resultOfJ = resultList.get(j);
                List<String> resultOfJ1 = resultList.get(j1);
                for (String s : resultOfJ) {
                    for (String s1 : resultOfJ1) {
                        result.add("(" + s + ")" + s1);
                    }
                }
            }
            resultList.add(result);
        }
        return resultList.get(n);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}