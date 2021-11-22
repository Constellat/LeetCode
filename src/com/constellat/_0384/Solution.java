package com.constellat._0384;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums.clone();
    }

    public int[] shuffle() {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Random random = new Random();
            int index = random.nextInt(i + 1);
            for (int i1 = array.length - 1; i1 > index; i1--) {
                array[i1] = array[i1 - 1];
            }
            array[index] = nums[i];
        }
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        int[] array = solution.shuffle();

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */