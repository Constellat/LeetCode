package com.constellat._0563;

public class RightSolution {

    public static int result = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return result;
    }

    /**
     * 计算root及子节点的总和
     * @param root
     */
    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        result = result + Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}