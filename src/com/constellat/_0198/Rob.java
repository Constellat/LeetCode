package com.constellat._0198;

public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] array = new int[nums.length];
        array[0] = nums[0];
        array[1] = Math.max(nums[0], nums[1]);
        for (int index = 2; index < nums.length; index++) {
            array[index] = Math.max(array[index - 2] + nums[index], array[index - 1]);
        }
        return array[nums.length - 1];
    }

    public static void main(String[] args) {

    }
}
