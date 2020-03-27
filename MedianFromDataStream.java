package com.prep.test.algo.search;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    private static PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> large = new PriorityQueue<>();
    private static boolean even = true;

    public static double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public static void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        addNum(1);
        addNum(2);
     double m =   findMedian();

        System.out.println(" median "+ m);

        addNum(3);
      double n =  findMedian();

        System.out.println(" median "+ n);
    }
}
