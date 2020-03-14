package com.prep.test.algo.datastructure;

//reverse a link list
/*

  list 2 -> 4 -> 6 ->null

  Reversed List 6 ->4 ->2 ->null

*/
public class ReverseLinkedList{

    public static class ListNode{

        int val;
        ListNode next;

        public ListNode(int v){
            this.val = v;
            this.next = null;
        }

    }

    public static ListNode reverseList(ListNode head){

        ListNode nNode = null;

        while(head !=null){
            ListNode next  = head.next;
            head.next = nNode;
            nNode = head;
            head = next;

        }

        return nNode;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);

        ListNode res =  reverseList(head);

        System.out.println(""+res);

    }
}
