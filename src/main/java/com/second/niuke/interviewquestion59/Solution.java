package com.second.niuke.interviewquestion59;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        return isSymmetricalCore(pRoot.left,pRoot.right);
    }
    boolean isSymmetricalCore(TreeNode left,TreeNode right){
        if((left==null&&right!=null)
                ||(left!=null&&right==null)
                ||(left!=null&&right!=null&&left.val!=right.val)){
            return false;
        }
        if(left==null&&right==null){
            return true;
        }
        return isSymmetricalCore(left.left,right.right)&&isSymmetricalCore(left.right,right.left);
    }
}
