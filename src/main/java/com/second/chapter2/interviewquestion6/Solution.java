package com.second.chapter2.interviewquestion6;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author yangkuan
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre==null||pre.length==0){
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, inMap, 0);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, Map inMap, int inStart) {
        if(preStart>preEnd){
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int midIndex = (Integer) inMap.get(pre[preStart]);
        int len = midIndex - inStart;
        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + len, inMap, inStart);
        root.right = reConstructBinaryTree(pre, preStart + len + 1, preEnd, inMap, midIndex + 1);
        return root;
    }

    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution solution = new Solution();
        TreeNode root = solution.reConstructBinaryTree(pre, in);
        solution.postorderTraversal(root);

    }
}
