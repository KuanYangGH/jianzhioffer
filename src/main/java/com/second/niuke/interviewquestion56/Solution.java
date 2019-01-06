package com.second.niuke.interviewquestion56;

/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
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

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
