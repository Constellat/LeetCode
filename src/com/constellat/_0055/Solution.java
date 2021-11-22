package com.constellat._0055;

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] array = new boolean[nums.length];
        array[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (array[i]) {
                for (int step = 1; step <= nums[i]; step++) {
                    if (i + step < nums.length) {
                        array[i + step] = true;
                    }
                }
            } else {
                return false;
            }
        }
        return array[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canJump(new int[]{2, 3, 1, 1, 4});
    }
}