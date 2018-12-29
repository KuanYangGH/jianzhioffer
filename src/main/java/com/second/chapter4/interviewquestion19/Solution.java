package com.second.chapter4.interviewquestion19;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
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
    public void Mirror(TreeNode root) {
        if(root!=null){
            swap(root);
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }
    }

    private void swap(TreeNode node){
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
    }
}
