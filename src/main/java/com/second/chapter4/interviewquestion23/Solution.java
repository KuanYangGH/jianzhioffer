package com.second.chapter4.interviewquestion23;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        PrintFromTopToBottomCore(queue, list);
        return list;
    }

    private void PrintFromTopToBottomCore(LinkedList queue, ArrayList list) {
        if (queue.isEmpty()) {
            return;
        }
        TreeNode node = (TreeNode) queue.poll();
        list.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        PrintFromTopToBottomCore(queue, list);
    }

    public void test() {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        ArrayList<Integer> list = PrintFromTopToBottom(node);
        for (Integer i:list){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
