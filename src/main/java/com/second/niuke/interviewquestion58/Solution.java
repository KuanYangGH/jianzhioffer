package com.second.niuke.interviewquestion58;


/**
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        TreeLinkNode nextNode = null;
        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while (node.left!=null){
                node = node.left;
            }
            nextNode = node;
        }
        else {
            TreeLinkNode node = pNode;
            while (node.next!=null&&node.next.right==node){
                node = node.next;
            }
            nextNode = node.next;
        }
        return nextNode;
    }
}
