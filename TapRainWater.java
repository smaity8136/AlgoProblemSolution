package com.prep.test.algo.datastructure;

public class TapRainWater {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    res += maxleft - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= maxright) {
                    maxright = height[right];
                } else {
                    res += maxright - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

      int [] pipe = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        int water = trap(pipe);

        System.out.println("water count : "+water);
    }
}
