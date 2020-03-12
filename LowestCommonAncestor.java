package com.prep.test.algo.search;


class LowestCommonAncestor{

    static class TreeNode{

        int val;

        TreeNode left;
        TreeNode right;

        public TreeNode(int v){
            this.val = v;
            this.left = null;
            this.right = null;


        }
    }



    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){

        if(root == null || p == root || q == root) return root;

        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca (root.right,p,q);

        if (left!=null && right != null){
            return root;
        }else if (right==null){
            return left;
        }else if (left == null){
            return right;
        }


        return null;

    }

    public static void main(String [] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode v1 = lca(root , root.left,  root.left.right.right);

        System.out.println("ancestor :"+ v1.val);

        //TreeNode
    }


}
