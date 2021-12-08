package com.constellat._0689;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] locations = new int[3];
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int maxSum1Idx = 0;
        int maxSum2Idx1 = 0;
        int maxSum2Idx2 = 0;
        for (int i = k * 2; i < nums.length; i++) {
            if (i < 3 * k) {
                sum1 += nums[i - k * 2];
                sum2 += nums[i - k];
                sum3 += nums[i];
            } else {
                sum1 -= nums[i - k * 3];
                sum2 -= nums[i - k * 2];
                sum3 -= nums[i - k];
                sum1 += nums[i - k * 2];
                sum2 += nums[i - k];
                sum3 += nums[i];
            }
            if (sum1 > max1) {
                max1 = sum1;
                maxSum1Idx = i - k * 3 + 1;
            }
            if (max1 + sum2 > max2) {
                max2 = max1 + sum2;
                maxSum2Idx1 = maxSum1Idx;
                maxSum2Idx2 = i - k * 2 + 1;
            }
            if (max2 + sum3 > max3) {
                max3 = max2 + sum3;
                locations[0] = maxSum2Idx1;
                locations[1] = maxSum2Idx2;
                locations[2] = i - k + 1;
            }
        }
        return locations;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        Solution solution = new Solution();
        int[] result = solution.maxSumOfThreeSubarrays(nums, k);
        for (int s = 0; s < result.length; s++) {
            System.out.println(result[s]);
        }
    }
}
