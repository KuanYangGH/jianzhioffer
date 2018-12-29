package com.second.chapter4.interviewquestion22;


import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author yangkuan
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA==null||popA==null||pushA.length==0||popA.length==0){
            return false;
        }
        int pushAIndex = 0, popAIndex = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[pushAIndex]);
        pushAIndex++;
        while (true){
            while (stack.peek()!=popA[popAIndex]&&pushAIndex<pushA.length){
                stack.push(pushA[pushAIndex]);
                pushAIndex++;
            }
            while (popAIndex<popA.length&&stack.peek()==popA[popAIndex]){
                stack.pop();
                popAIndex++;
            }
            if(pushAIndex==pushA.length&&!stack.empty()){
                return false;
            }
            if(pushAIndex==pushA.length&&stack.empty()&&popAIndex==popA.length){
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.print(new Solution().IsPopOrder(pushA,popA));
    }
}
