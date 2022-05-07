package com.constellat._1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            int temp = numBottles % numExchange;
            result += numBottles / numExchange;
            numBottles = temp + numBottles / numExchange;
        }
        result += numBottles;
        return result;
    }
}