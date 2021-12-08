package com.constellat._1816;

class Solution {
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        if (k >= strings.length) {
            return s;
        }
        if (k == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(" ").append(strings[i]);
        }
        return stringBuilder.substring(1).toString();
    }
}