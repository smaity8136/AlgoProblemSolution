package com.leetcode.amazone.test;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeDeserializeBT{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v){
            this.val = v;
            this.left = null;
            this.right= null;

        }

    }


    public static String serializeBT(TreeNode root){

        if(root == null) return "";

        StringBuilder sb = new StringBuilder();

        return serializeHelper(root,sb);

    }

    public static String serializeHelper(TreeNode root, StringBuilder sb){

        if(root == null){
            sb.append("#,");
            return sb.toString();
        }

        sb.append(root.val+",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);

        return sb.toString();

    }

    public static TreeNode deserializeBT(String str){

        String [] stArr = str.split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(stArr));
        return deSerializeHelper(deque);
    }

    public static TreeNode deSerializeHelper(Deque<String> deque){

        if (deque.isEmpty()) {
            return null;
        }

        String node = deque.removeFirst();
        if (node.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deSerializeHelper(deque);
        root.right = deSerializeHelper(deque);

        return root;


    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        String result = serializeBT(root);

        TreeNode root2 = deserializeBT(result);

        //String result2 = sol.serialdfs(root2);

        System.out.println(result);
    }


}
