package com.second.chapter3.interviewquestion18;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean flag = doesHasSubTree(root1, root2);
        if (flag) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean doesHasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return doesHasSubTree(root1.left, root2.left) && doesHasSubTree(root1.right, root2.right);
    }

    public void test() {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        TreeNode subNode1 = new TreeNode(8);
        TreeNode subNode2 = new TreeNode(9);
        TreeNode subNode3 = new TreeNode(2);
        subNode1.left = subNode2;
        subNode1.right = subNode3;

        System.out.print(HasSubtree(node, subNode1));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
