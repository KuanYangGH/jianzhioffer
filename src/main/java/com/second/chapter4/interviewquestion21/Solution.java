package com.second.chapter4.interviewquestion21;
import java.util.Stack;
/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author yangkuan
 */
public class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.empty()){
            minStack.push(node);
        }
        else {
            minStack.push(minStack.peek()<node?minStack.peek():node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }


    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
