package com.prep.test.algo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListAddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultListNode = null;
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();

        while(l1!=null){
            arr1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){


            arr2.add(l2.val);


            l2 = l2.next;


        }

        int num1 = getNum(arr1);
        int num2 = getNum(arr2);

        int sum = num1+num2;

        System.out.println("sum "+sum);

        int resultArr[] = convertIntToIntArray(sum);

        resultListNode = populateResult(resultArr);

        //printArray(arr1);
        //System.out.println("arr1 size"+arr1.size());
        //arr1.

        return resultListNode;
    }

    public void printArray(List<Integer> arr){
        for (int a : arr){
            System.out.println("element "+a);
        }

    }

    public int getNum(List<Integer> arr){

        int numArr [] = toIntArray(arr);
        int num = 0;

        for (int i = numArr.length -1; i>=0;i--){

            System.out.println("index "+i);

            if (i>0){
                num =num+((int)Math.pow(10,i)*numArr[i]);
            }else{
                num =num+numArr[i];
            }


        }

        System.out.println("Number  "+num);

        return num;
    }

    public int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    public int [] convertIntToIntArray(int num){
        String temp = Integer.toString(num);
        int[] resultArr = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            resultArr[i] = temp.charAt(i) - '0';
        }

        List<Integer> intList = new ArrayList<Integer>(resultArr.length);
        for (int i : resultArr)
        {
            intList.add(i);
        }

        printArray(intList);

        return resultArr;
    }

    public ListNode populateResult(int arr[]){

        int l = arr.length;
        ListNode resultListNode = null;
        ListNode ptr;
        for(int i=l-1;i>=0;i--){

            ListNode node = new ListNode(arr[i]);
            node.next = null;

            if (resultListNode==null){
                resultListNode = node;


                // resultListNode.next = null;

            }else{
                ptr = resultListNode;

                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = new ListNode(arr[i]);
            }




            //


        }

        return resultListNode;
    }

    private class ListNode {
        int val;
   ListNode next;
   ListNode(int x) { val = x; }
    }
}
