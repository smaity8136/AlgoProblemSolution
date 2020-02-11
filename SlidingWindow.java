package com.leetcode.amazone.test;

public class SlidingWindow {

    public int getMaxSum(int arr[], int k){
        int n = arr.length;
        int maxsum =0;
//        for(int i=0; i<n-k+1;i++){
//            int current_sum=0;
//            for(int j=0; j<k; j++){
//                current_sum = current_sum+arr[i+j];
//            }
//            maxsum = Math.max(current_sum,maxsum);
//        }


        int max_sum = 0, window_sum = 0;
        /* calculate sum of 1st window */
        for (int i = 0; i < k; i++)  window_sum += arr[i];
        /* slide window from start to end in array. */

        for (int i = k; i < n; i++){
            window_sum += arr[i] - arr[i-k];    // saving re-computation
            max_sum = Math.max(max_sum, window_sum);
        }
        return max_sum;
    }


    public static void main(String[] args) {
        int arr[] ={100,500,300,400};
        int k=2;

        SlidingWindow sw = new SlidingWindow();
        int max = sw.getMaxSum(arr,k);
        System.out.println("max "+max);
    }
}
