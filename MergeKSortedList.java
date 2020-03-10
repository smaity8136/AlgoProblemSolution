package com.leetcode.amazone.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    /*
    * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    * Example:
    * Input:
    *
        [
          1->4->5,
          1->3->4,
          2->6
        ]
    *   Output: 1->1->2->3->4->4->5->6
    *
    * */

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;

    }

    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val=val;
        }
    }

    public static void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[]=new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        // Merge all lists
        ListNode head = mergeKLists(arr);
        printList(head);
    }

}
