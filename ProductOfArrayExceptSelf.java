package com.prep.test.algo.search;


import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int [] calculateProductOFArray(int [] nums){

        int n = nums.length;
        int [] res = new int [n];
        int left = 1;

        for (int i=0;i<n;i++){

            if(i>0){
                left =  left * nums[i-1];

            }
            res[i]= left;
        }
        int right =1;

        for (int j = n-1;j>= 0;j--){
            if(j<n-1){
                right = right* nums[j+1];

            }
            res[j]*=right;
        }
        return res;
    }


    public static void main(String[] args) {
        int [] nums = new int[]{2,3,4,5};

      int [] res =   calculateProductOFArray(nums);

      //  Arrays.asList(res).stream().forEach( c-> System.out.println(""+c));

    }

}
