package com.constellat._0005;

class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] array = new boolean[length][length];
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < length; i++) {
            array[i][i] = true;
            max = Math.max(max, 1);
        }
        for (int i = 0; i < length - 1; i++) {
            array[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (array[i][i + 1]) {
                max = Math.max(max, 2);
                maxLeft = i;
                maxRight = i + 1;
            }
        }
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                array[i][j] = array[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (array[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        maxLeft = i;
                        maxRight = j;
                    }
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abacab"));
    }
}