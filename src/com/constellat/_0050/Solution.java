package com.constellat._0050;

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / myPow(x, -n - 1) / x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double value = myPow(x, n / 2);
            return value * value;
        } else {
            double value = myPow(x, n / 2);
            return value * value * x;
        }
    }
}