package com.constellat._0997;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustPersonNums = new int[n];
        int[] trustedPersonNums = new int[n];
        for (int[] ints : trust) {
            int trustPerson = ints[0] - 1;
            int trustedPerson = ints[1] - 1;
            trustPersonNums[trustPerson]++;
            trustedPersonNums[trustedPerson]++;
        }

        for (int i = 0; i < n; i++) {
            if (trustPersonNums[i] == 0 && trustedPersonNums[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] trust = new int[][]{{1, 2}};
        System.out.println(solution.findJudge(2, trust));
    }
}