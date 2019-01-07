package com.second.niuke.interviewquestion57;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode last = newHead;
        while (last != null) {
            ListNode node = last.next;
            ListNode tmpNode = node;
            while (node != null && node.next != null && node.next.val == node.val) {
                node = node.next;
            }
            if(tmpNode!=node){
                last.next = node.next;
            }else {
                last = last.next;
            }
        }
        return newHead.next;
    }

    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode pHead = deleteDuplication(node1);
        while (pHead != null) {
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
