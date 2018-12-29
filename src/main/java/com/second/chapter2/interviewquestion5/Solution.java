package com.second.chapter2.interviewquestion5;

/**
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author yangkuan
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = listNode;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public void test() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        System.out.print(printListFromTailToHead(null));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
