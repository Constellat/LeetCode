package com.constellat._0563;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int findTilt(TreeNode root) {
        calNodeValue(root);
        calSubValue(root);
        return calResult(root);
    }

    public int calResult(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return root.val + calResult(root.right) + calResult(root.left);
    }

    public void calSubValue(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.val = 0;
        } else if (root.left == null) {
            root.val = Math.abs(root.right.val);
            calSubValue(root.right);
        } else if (root.right == null) {
            root.val = Math.abs(root.left.val);
            calSubValue(root.left);
        } else {
            root.val = Math.abs(root.left.val - root.right.val);
            calSubValue(root.left);
            calSubValue(root.right);
        }
    }

    public void calNodeValue(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left == null) {
            calNodeValue(root.right);
            root.val = root.val + root.right.val;
        } else if (root.right == null) {
            calNodeValue(root.left);
            root.val = root.val + root.left.val;
        } else {
            calNodeValue(root.left);
            calNodeValue(root.right);
            root.val = root.val + root.left.val + root.right.val;
        }
    }
}