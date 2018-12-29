package com.second.chapter3.interviewquestion16;

/**
 * 翻转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
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

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode nextNode = node.next;
        node.next = null;
        while (nextNode != null) {
            ListNode tmp = nextNode.next;
            nextNode.next = node;

            node = nextNode;
            nextNode = tmp;
        }
        return node;
    }

    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode head=ReverseList(node1);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        new Solution().test();
    }
}
