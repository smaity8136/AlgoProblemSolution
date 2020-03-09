package com.leetcode.amazone.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

    /*
    * Given an array of integers, find two numbers such that they add up to a specific target number.
    * The function twoSum should return indices of the two numbers such that they add up to the target,
    * where index1 must be less than index2.
    * Please note that your returned answers (both index1 and index2) are not zero-based.
    * Example
    * Input: numbers={2, 7, 11, 15}, target=9
    * Output: index1=0, index2=1
    * */

    public static int[] twoSum(int[] nums, int target) {

        if(nums.length == 0) return null;
        int[]  res = null;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n ; i++){
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i],i);
            }else{
                int j = map.get(nums[i]);
               res=  new int []{j,i};
                break;
            }


        }

        return res;
    }

    public static void main(String[] args) {
        int [] numbers = new int [] {2, 7, 11, 15};
        int target=9 ;

        int[]  res = twoSum(numbers,target);

       List<Integer> lst =  Arrays.stream(res).boxed().collect(Collectors.toList());
        lst  .forEach(c -> System.out.println(""+c));
    }

}
