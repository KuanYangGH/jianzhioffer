package com.second.chapter4.interviewquestion26;

/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author yangkuan
 */
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        while (node != null) {
            cloneNode(node);
            node = node.next.next;
        }
        node = pHead;
        while (node != null) {
            RandomListNode newNode = node.next;
            if(node.random!=null){
                newNode.random = node.random.next;
            }
            node = node.next.next;
        }
        //split two list
        return splitList(pHead);
    }

    private void cloneNode(RandomListNode node) {
        RandomListNode newNode = new RandomListNode(node.label);
        RandomListNode nextNode = node.next;
        node.next = newNode;
        newNode.next = nextNode;
    }

    private RandomListNode splitList(RandomListNode headNode) {
        RandomListNode clonedHeadNode = headNode.next;
        RandomListNode node = headNode;
        RandomListNode clonedNode = clonedHeadNode;
        node.next = clonedNode.next;
        node = node.next;
        while (node!=null){
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHeadNode;
    }

    public void test() {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next=node4;
        node4.next=node5;
        node1.random = node3;
        node2.random = node5;
        node4.random = node2;
        RandomListNode clonedHead = Clone(node1);
        while (clonedHead != null) {
            System.out.print(clonedHead.label + ":" + (clonedHead.random!=null?clonedHead.random.label:"#") + " ");
            clonedHead = clonedHead.next;
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
