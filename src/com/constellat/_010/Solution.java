package com.constellat._010;

class Solution {
    public static boolean isMatch0(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] pattern = new boolean[sLength + 1][pLength + 1];
        pattern[0][0] = true;
        for (int sIndex = 0; sIndex <= sLength; sIndex++) {
            for (int pIndex = 1; pIndex <= pLength; pIndex++) {
                if (p.charAt(pIndex - 1) == '*') {
                    pattern[sIndex][pIndex] = pattern[sIndex][pIndex - 2];
                    if (matches(s, p, sIndex, pIndex - 2)) {
                        pattern[sIndex][pIndex] = pattern[sIndex][pIndex] || pattern[sIndex - 1][pIndex];
                    }
                } else {
                    if (matches(s, p, sIndex, pIndex - 1)) {
                        pattern[sIndex][pIndex] = pattern[sIndex - 1][pIndex - 1];
                    }
                }
            }
        }
        return pattern[sLength][pLength];
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 2)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch0("aa", "a*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch0("aa", "a"));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch0("", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch0("aab", "c*a*b"));
    }
}