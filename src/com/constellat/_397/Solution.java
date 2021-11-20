package com.constellat._397;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerReplacement(2147483647));
    }

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count++;
            } else {
                //最左端有一个1 就减一 其他都加一
                if (n % 4 == 1) {
                    n = n >> 1;
                    count += 2;
                } else {
                    if (n == 3) {
                        n = 1;
                        count += 2;
                    } else {
                        n = n >> 1;
                        n++;
                        count += 2;
                    }
                }
            }
        }
        return count;
    }
}