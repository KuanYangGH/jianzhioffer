package com.second.algorithm;

import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author yangkuan
 */
public class Traversal {
    /**
     * Definition for binary tree node
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }

    public void preorderTraversalRecursive(TreeNode head) {
        if (head != null) {
            visit(head);
            preorderTraversalRecursive(head.left);
            preorderTraversalRecursive(head.right);
        }
    }

    public void inorderTraversalRecursive(TreeNode head) {
        if (head != null) {
            inorderTraversalRecursive(head.left);
            visit(head);
            inorderTraversalRecursive(head.right);
        }
    }

    public void postorderTraversalRecursive(TreeNode head) {
        if (head != null) {
            postorderTraversalRecursive(head.left);
            postorderTraversalRecursive(head.right);
            visit(head);
        }
    }

    public void preorderTraversalNonRecursive(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            visit(node);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public void inorderTraversalNonRecursive(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.empty()) {
            TreeNode treeNode = stack.pop();
            visit(treeNode);
            if (treeNode.right != null) {
                TreeNode rightNode = treeNode.right;
                while (rightNode != null) {
                    stack.push(rightNode);
                    rightNode = rightNode.left;
                }
            }
        }
    }

    public void postorderTraversalNonRecursive(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = head;
        TreeNode pre = head;
        stack.push(node);
        while (!stack.empty()) {
            TreeNode treeNode = stack.peek();
            // 叶子节点、左右子树都被访问过（如果有右子树，那么前驱节点为右孩子；否则为左孩子）
            if ((treeNode.left == null && treeNode.right == null)
                    || (treeNode.right != null && treeNode.right == pre)
                    || treeNode.left == pre) {
                stack.pop();
                visit(treeNode);
                pre = treeNode;
            } else {
                if (treeNode.right != null) stack.push(treeNode.right);
                if (treeNode.left != null) stack.push(treeNode.left);
            }
        }
    }

    public void inorderMorrisTraversal(TreeNode root) {
        TreeNode current = root, prev = null;

        while (current != null) {
            if (current.left == null) {
                visit(current);
                current = current.right;
            } else {
                prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    visit(current);
                    current = current.right;
                }
            }
        }
    }

    public void preorderMorrisTraversal(TreeNode root) {
        TreeNode current = root, prev = null;
        while (current!=null){
            if(current.left==null){
                visit(current);
                current = current.right;
            }
            else {
                prev = current.left;
                while (prev.right!=null&&prev.right!=current){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = current;
                    visit(current);
                    current = current.left;
                }
                else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }
    }

    public void test() {
        TreeNode head = createBinaryTree();

        System.out.println("先序遍历");
        preorderTraversalRecursive(head);
        System.out.println();
        preorderTraversalNonRecursive(head);
        System.out.println();
        preorderMorrisTraversal(head);
        System.out.println();


        System.out.println("###############");
        System.out.println("中序遍历");
        inorderTraversalRecursive(head);
        System.out.println();
        inorderTraversalNonRecursive(head);
        System.out.println();
        inorderMorrisTraversal(head);
        System.out.println();

        System.out.println("###############");
        System.out.println("后序遍历");
        postorderTraversalRecursive(head);
        System.out.println();
        postorderTraversalNonRecursive(head);
    }

    private TreeNode createBinaryTree() {
        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);


        head.left = node2;
        head.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        return head;
    }

    public static void main(String[] args) {
        new Traversal().test();
    }

}
