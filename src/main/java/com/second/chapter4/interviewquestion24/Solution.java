package com.second.chapter4.interviewquestion24;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @author yangkuan
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int startIndex, int endIndex) {
        if(startIndex==endIndex||startIndex>endIndex){
            return true;
        }
        int rootValue = sequence[endIndex];
        // find left tree
        int rightStartIndex = startIndex;
        while (sequence[rightStartIndex] < rootValue) {
            rightStartIndex++;
        }
        for(int i=rightStartIndex;i<endIndex;i++){
            if(sequence[i]<rootValue){
                return false;
            }
        }
        return VerifySquenceOfBST(sequence,startIndex,rightStartIndex-1)
                &&VerifySquenceOfBST(sequence,rightStartIndex,endIndex-1);
    }

    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        System.out.print(new Solution().VerifySquenceOfBST(sequence));
    }
}
