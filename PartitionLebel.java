package com.leetcode.amazone.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLebel {

/*
* Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
* */

    public static List<Integer> partitionLabels(String str) {
        List<Integer> res = new ArrayList<>();

        Map<Character,Integer> map = new HashMap<>();

        if(str.length() == 0) return null;
        int l = str.length();
      

        for (int i=0; i<l;i++ ){
            char c = str.charAt(i) ;
            if(!map.containsKey(c)){
                map.put(c, getLastIndex(c,str,i));
            }
        }

        int max = 0;
        int min = 0;
        int i =0;

        for(;i<l;i++){
            char cr = str.charAt(i) ;
            if(i>max){
                max+=1;
                res.add(max-min);
                min = max;
                max = map.get(cr);
            }else{
                max = Math.max(max,map.get(cr));
            }
        }
        if(i>max){
            res.add(max - min + 1);
        }




      return res;
    }

    public static int getLastIndex(char c, String str, int i) {
          for (int j=i; j<str.length();j++){

            if(c==str.charAt(i) ) i=j;
        }
        return i;
    }

    public static void main(String[] args) {
       String S = "ababcbacadefegdehijhklij";

        List<Integer> rest = partitionLabels(S);

    rest.forEach(n ->     System.out.println(""+n));
    }

}
