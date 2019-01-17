package com.second.niuke.interviewquestion63;

/**
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
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

    int index = 1;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) {
            return null;
        }
        return inOrderTraversal(pRoot, k);
    }

    TreeNode inOrderTraversal(TreeNode pRoot, int k) {
        TreeNode node = null;
        if (pRoot.left != null) node = inOrderTraversal(pRoot.left, k);
        if (node != null) return node;
        if (index == k) {
            return pRoot;
        }
        index++;
        if (pRoot.right != null) node = inOrderTraversal(pRoot.right, k);
        return node;
    }

    public void test() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode node = KthNode(root, 3);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
