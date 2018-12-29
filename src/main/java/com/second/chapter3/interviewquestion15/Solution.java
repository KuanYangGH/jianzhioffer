package com.second.chapter3.interviewquestion15;


/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author yangkuan
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int loc = len - k;
        if (loc < 0) {
            return null;
        }
        node = head;
        for (int i = 0; i < loc; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
