package com.constellat._0241;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (isOperation(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer leftValue : left) {
                    for (Integer rightValue : right) {
                        result.add(isOperation(leftValue, rightValue, expression.charAt(i)));
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

    private Integer isOperation(int a, int b, char ch) {
        if (ch == '+') {
            return a + b;
        } else if (ch == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

    private boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1"));
    }
}