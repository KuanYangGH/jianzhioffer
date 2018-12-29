package com.second.chapter5.interviewquestion37;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
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

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        if (len1 > len2) {
            int steps = len1 - len2;
            //pHead1 first go steps
            pHead1 = goNSteps(pHead1, steps);
        } else {
            int steps = len2 - len1;
            //pHead2 first go steps
            pHead2 = goNSteps(pHead2, steps);
        }
        while (pHead1!=pHead2&&pHead1!=null&&pHead2!=null){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    private int getLength(ListNode pHead) {
        int len = 0;
        while (pHead != null) {
            len++;
            pHead = pHead.next;
        }
        return len;
    }

    private ListNode goNSteps(ListNode pHead, int steps) {
        for (int i = 0; i < steps; i++) {
            pHead = pHead.next;
        }
        return pHead;
    }
}
