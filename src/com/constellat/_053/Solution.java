package com.constellat._053;

class Solution {

    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int max = pre;
        for (int index = 1; index < nums.length; index++) {
            pre = pre > 0 ? pre + nums[index] : nums[index];
            max = Math.max(max, pre);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] array = new int[nums.length];
        array[0] = nums[0];
        int max = array[0];
        for (int index = 1; index < nums.length; index++) {
            array[index] = array[index - 1] > 0 ? array[index - 1] + nums[index] : nums[index];
            max = Math.max(max, array[index]);
        }
        return max;
    }
}