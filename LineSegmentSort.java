package com.prep.test.algo.search;

import java.util.*;

public class LineSegmentSort {

    static class Segment implements Comparable<Segment>{
        int first;
        int second;

        Segment(int f, int s){
            this.first = f;
            this.second = s;
        }

        @Override
        public int compareTo(Segment segment) {
            int result = Integer.compare(this.first,segment.first);
            if(result==0){
                result=Integer.compare(this.second,segment.second);
            }
            return result;
        }

        @Override
        public String toString() {
           return new StringBuilder().append("  "+this.first).append("-").append(""+this.second).toString();

        }
    }

    public static List<Segment> getSortedSegments(List<Segment> segments){

        Collections.sort(segments);

        List<Segment> rList = new ArrayList<>();

        Stack<Segment> stack=new Stack<>();

        segments.stream().map(s -> s).forEach(System.out::print);

        stack.push(segments.get(0));

        for(Segment s : segments){
            Segment top = stack.peek();

            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.second < s.first)
                stack.push(s);

                // Otherwise update the ending time of top if ending of current
                // interval is more
            else if (top.second < s.second)
            {
                top.second = s.second;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.print("\nThe Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Segment t = stack.pop();


            rList.add(t);
           // System.out.print("["+t.first+","+t.second+"] ");

        }

        Collections.reverse(rList);
        return rList;

    }


    public static void main(String[] args) {

        List<Segment> sList = new ArrayList<>();
        Segment s3 = new Segment(5,7);
        sList.add(s3);
        Segment s1 = new Segment(1,3);
        sList.add(s1);
        Segment s4 = new Segment(6,9);
        sList.add(s4);
        Segment s2 = new Segment(2,4);
        sList.add(s2);
        sList.stream().map(s -> s).forEach(System.out::print);

        System.out.println("\n");


        List<Segment> rList = getSortedSegments(sList);

        rList.stream().map(s -> s).forEach(System.out::print);
       // System.out.println(Arrays.binarySearch(cities,"ban"));;
    }


}
