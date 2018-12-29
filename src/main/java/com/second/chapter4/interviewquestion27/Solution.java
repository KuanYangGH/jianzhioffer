package com.second.chapter4.interviewquestion27;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode lastNodeOfList = null;
        lastNodeOfList = inOrderTraversal(pRootOfTree, lastNodeOfList);
        TreeNode firstNodeOfList = lastNodeOfList;
        while (firstNodeOfList.left!=null){
            firstNodeOfList = firstNodeOfList.left;
        }
        return firstNodeOfList;
    }

    private TreeNode inOrderTraversal(TreeNode root, TreeNode lastNodeOfList) {
        if (root.left != null) lastNodeOfList = inOrderTraversal(root.left, lastNodeOfList);

        root.left = lastNodeOfList;
        if (lastNodeOfList != null) {
            lastNodeOfList.right = root;
        }
        lastNodeOfList = root;
        if (root.right != null) lastNodeOfList = inOrderTraversal(root.right, lastNodeOfList);
        return lastNodeOfList;
    }

    public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(12);
        root.left = node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(9);
        node1.left=node3;
        node1.right=node4;
        TreeNode node5 = new TreeNode(11);
        node2.left=node5;
        TreeNode node = Convert(root);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
