package com.second.chapter3.interviewquestion17;


/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode preHead = new ListNode(0);
        ListNode index = preHead;
        while (node1!=null&&node2!=null){
            ListNode node;
            if(node1.val<node2.val){
                node = node1;
                node1 = node1.next;
            }
            else {
                node = node2;
                node2 = node2.next;
            }
            index.next = node;
            index = index.next;
        }
        while (node1!=null){
            index.next = node1;
            node1 = node1.next;
            index = index.next;
        }
        while (node2!=null){
            index.next = node2;
            node2 = node2.next;
            index = index.next;
        }
        return preHead.next;
    }

}
