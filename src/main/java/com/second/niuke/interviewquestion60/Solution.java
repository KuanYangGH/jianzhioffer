package com.second.niuke.interviewquestion60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 按之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (pRoot == null) {
            return results;
        }
        boolean leftToRight = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.addLast(pRoot);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    result.add(node.val);
                } else {
                    stack.push(node);
                }
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            while (!stack.empty()) {
                result.add(stack.pop().val);
            }
            results.add(result);
            leftToRight ^= true;
        }
        return results;
    }
}
