package com.constellat._0213;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] array = new int[end - start + 1];
        array[0] = nums[start];
        array[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < array.length; i++) {
            array[i] = Math.max(array[i - 2] + nums[i + start], array[i - 1]);
        }
        return array[array.length - 1];
    }
}