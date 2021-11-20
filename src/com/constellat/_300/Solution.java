package com.constellat._300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] array = new int[nums.length + 1];
        int max = 0;
        array[0] = 0;
        array[1] = 1;
        for (int index = 2; index <= nums.length; index++) {
            array[index] = 1;
            for (int i = index - 1; i > 0; i--) {
                if (nums[i - 1] < nums[index - 1]) {
                    array[index] = Math.max(array[index], array[i] + 1);
                }
            }
            max = Math.max(max, array[index]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}