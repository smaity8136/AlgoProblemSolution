package com.leetcode.amazone.test;



public class ProductOfArray3{


    public static int [] calculateProductExceptSelf(int [] arr){

        int n = arr.length;
        int right =1,left =1;
        int [] res = new int [n];

        for (int i=0; i<n;i++){

            res[i] = 1;
        }

        for(int i=0;i<n ; i++){

            res[i]*= left;
            left*= arr[i];
        }

        for(int i=n-1;i>=0; i--){
            res[i]*= right;
            right*= arr[i];

        }

        return res;
    }

    public static void main(String [] args){

        int [] nums = new int [] {2,3,4,5};

        int [] res = calculateProductExceptSelf(nums);

        int n = res.length;

        for (int i=0;i<n;i++){

            System.out.println(" "+res[i]);
        }


    }

}
