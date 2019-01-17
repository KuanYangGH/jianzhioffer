package com.second.niuke.interviewquestion61;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (pRoot == null) {
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            results.add(result);
        }
        return results;
    }
}
