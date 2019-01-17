package com.second.niuke.interviewquestion62;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
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

    int index = 0;

    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#,");
        } else {
            stringBuilder.append(root.val + ",");
            stringBuilder.append(Serialize(root.left));
            stringBuilder.append(Serialize(root.right));
        }
        return stringBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        return Deserialize(strings);
    }

    TreeNode Deserialize(String[] strs) {
        if (strs[index].equals("#")) {
            index ++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
        index++;
        node.left = Deserialize(strs);
        node.right = Deserialize(strs);
        return node;
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        String s = Serialize(root);
        System.out.println(s);
        TreeNode node = Deserialize(s);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
