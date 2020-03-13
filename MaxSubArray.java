package com.leetcode.amazone.test;


public class MaxSubArray{

    public static int getMaxProfit(int [] prices){

        int n = prices.length;

        int maxprofit = 0;
        int minprice = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            if(prices[i]<minprice){
                minprice = prices[i];
            }else{
                maxprofit = Math.max(maxprofit, prices[i] - minprice);

            }


        }
        return maxprofit;
    }


    public static void main(String [] args){

        int [] prices  = new int[]  {100, 180, 260, 310, 40, 535, 695};

       int profit = getMaxProfit(prices);

    }

}
