package com.elearning.chapter3.interviewquestion18;

/**
 * 面试题18：树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author yangkuan
 * @date 018/05/17 22:01
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                result = doesTree1HasTree2(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return doesTree1HasTree2(root1.left,root2.left)&&doesTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {

    }
}
