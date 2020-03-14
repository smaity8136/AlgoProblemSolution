package com.prep.test.algo.datastructure;

public class AddTwoNumber {

    /*
    * You are given two non-empty linked lists representing two non-negative integers.
    * The digits are stored in reverse order and each of their nodes contain a single digit.
    * Add the two numbers and return it as a linked list.
    * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
    *
    *
    * */

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int v) {
            this.val = v;
            this.next = null;
        }
    }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2==null) return null;

        ListNode dummyHead = new ListNode(0);

        ListNode p = l1, q=l2, curr = dummyHead;
        int carry =0;

        while(p!=null || q!=null) {

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry>0){
            curr.next = new ListNode(carry);

        }
        return dummyHead.next;

        }


    public static void main(String[] args) {
        ListNode p = new ListNode(2);
        p.next = new ListNode(4);
        p.next.next = new ListNode(3);

        ListNode q  =  new ListNode(5);
        q.next = new ListNode(6);
        q.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(p,q);

        System.out.println(""+res);

    }
}