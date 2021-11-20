package com.constellat._0318;

class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] bitOfWordList = new int[length];
        // bitmap初始化
        for (int i = 0; i < length; i++) {
            bitOfWordList[i] = 0;
        }
        // words 转化为 bitmap
        for (int wordIndex = 0; wordIndex < length; wordIndex++) {
            String string = words[wordIndex];
            for (int charIndex = 0; charIndex < string.length(); charIndex++) {
                // temp表示已有字母计算对应bitmap里的标志位
                int temp = 1 << (string.charAt(charIndex) - 'a');
                // 转化为bitmap，所以要用或运算记录
                bitOfWordList[wordIndex] = bitOfWordList[wordIndex] | temp;
            }
        }
        int result = 0;
        // words 的 bitmap 之间相互比较
        for (int wordIndex = 0; wordIndex < length; wordIndex++) {
            for (int wordIndex2 = wordIndex + 1; wordIndex2 < length; wordIndex2++) {
                // bitmap 验证是否有重复字母，采取与运算
                if ((bitOfWordList[wordIndex] & bitOfWordList[wordIndex2]) == 0) {
                    result = Math.max(result, words[wordIndex].length() * words[wordIndex2].length());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}