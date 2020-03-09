package com.leetcode.amazone.test;

import java.util.ArrayList;
import java.util.List;

public class PartitionLebel2 {

    public static List<Integer> partitionLabels(String S) {
        int lastIndex[] = new int[128];
        for (int i = 0; i < S.length(); ++i)   lastIndex[(int)S.charAt(i)] = i;

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); ++i) {
            end = Math.max(end, lastIndex[(int)S.charAt(i)]);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";

        List<Integer> rest = partitionLabels(S);

        rest.forEach(n ->     System.out.println(""+n));
    }
}
