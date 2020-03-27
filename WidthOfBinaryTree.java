package com.prep.test.algo.search;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {


        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }


    // Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static void main(String[] args) {
        //int [] binarytree = new int []{1,3,2,5,3,null,9};

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
       // root.right.left = new TreeNode(null);
        root.right.right = new TreeNode(9);

        int maxwidth = widthOfBinaryTree(root);

        System.out.println("maxwidth : "+maxwidth);
    }
}
