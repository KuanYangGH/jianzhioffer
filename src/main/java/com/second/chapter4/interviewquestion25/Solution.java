package com.second.chapter4.interviewquestion25;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始
 * 往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
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

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root==null){
            return results;
        }
        preOrderTraversal(root,0,new ArrayList<>(),results,target);
        return results;
    }

    private void preOrderTraversal(TreeNode root, int sum, ArrayList<Integer> stack, ArrayList<ArrayList<Integer>> results, int target) {
        stack.add(root.val);
        sum += root.val;
        //the node is leaf and sum equal to target
        if(root.left==null&&root.right==null&&sum==target){
            ArrayList<Integer> newlist = new ArrayList<>();
            newlist.addAll(stack);
            results.add(newlist);
        }
        if(root.left!=null){
            preOrderTraversal(root.left,sum,stack,results,target);
        }
        if(root.right!=null){
            preOrderTraversal(root.right,sum,stack,results,target);
        }
        stack.remove(stack.size()-1);
    }
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;

        ArrayList<ArrayList<Integer>> results = FindPath(node1,3);
        for(ArrayList<Integer> result:results){
            for(Integer i:result){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
