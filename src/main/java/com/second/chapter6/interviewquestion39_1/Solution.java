package com.second.chapter6.interviewquestion39_1;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        int[] depth = new int[1];
        return preOrderTraversal(root,depth);
    }

    private boolean preOrderTraversal(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        boolean leftFlag = preOrderTraversal(root.left, depth);
        int leftDepth = depth[0];
        boolean rightFlag = preOrderTraversal(root.right, depth);
        int rightDepth = depth[0];
        // set tree depth
        depth[0] = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        // judge tree is balanced
        boolean flag = true;
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            flag = false;
        }
        return flag & leftFlag & rightFlag;
    }
}
