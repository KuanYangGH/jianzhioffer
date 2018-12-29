package com.second.interviewquestion39;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * @author yangkuan
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

    public int TreeDepth(TreeNode root) {
        return preOrderTraversal(root);
    }

    private int preOrderTraversal(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth = 1;
            int leftDepth = preOrderTraversal(root.left);
            int rightDepth = preOrderTraversal(root.right);
            depth += leftDepth > rightDepth ? leftDepth : rightDepth;
        }
        return depth;
    }
}
