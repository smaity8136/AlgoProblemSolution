package com.prep.test.algo.search;

import java.util.Arrays;

public class ProucudtOfArrayExceptSelf2 {
// this one having issue when use 0 in array element


    public static int [] calculateProductOFArray(int [] nums){

        int n = nums.length;
        int [] res = new int[n];
        int product =1;
        for (int i=0;i<n;i++){
            product = product * nums[i] ;
        }

        for (int i=0;i<n;i++){
            res[i] = product/nums[i];
        }


        return res;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2,3,4,5};

        int [] res =   calculateProductOFArray(nums);

       // Arrays.asList(res).stream().forEach(c-> System.out.println(""+c));

    }
}
