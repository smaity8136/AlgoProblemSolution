package com.prep.test.algo.datastructure;

import java.util.HashMap;
import java.util.Map;

class LRUCache{

    static class DlinkNode{
        int key;
        int val;

        DlinkNode pre;
        DlinkNode post;

        public void addNode(DlinkNode node, DlinkNode head){

            node.pre=head;
            node.post = head.post;
            head.post = node;
            node.post.pre = node;

        }

        public void deleteNode(DlinkNode node){

            DlinkNode pre =  node.pre;
            DlinkNode post = node.post;

            pre.post = post;

            post.pre = pre;


        }

        public void moveToHead(DlinkNode node, DlinkNode head){

            this.deleteNode(node);
            this.addNode(node,head);

        }

        public DlinkNode popTail(DlinkNode tail){

            DlinkNode res = tail.pre;
            this.deleteNode(res);
            return res;

        }

    }


    Map<Integer,DlinkNode > cache;
    int count=0,capacity=0;
    DlinkNode head,tail;

    public LRUCache(int capacity){

        this.capacity = capacity;
        this.head = new DlinkNode();
        this.tail = new DlinkNode();
        this.head.pre = null;
        this.tail.pre = head;
        this.tail.post = null;
        this.head.post = tail;
        cache = new HashMap<Integer,DlinkNode>();


    }

    public int get(int key) {

        DlinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        this.head.moveToHead(node,this.head);
        return node.val;
    }
  public void put (int key,int val){

            DlinkNode node = cache.get(key);

            if(node == null) {
                DlinkNode nNode = new DlinkNode();
                nNode.key = key;
                nNode.val = val;
                this.head.addNode(nNode, this.head);
                this.cache.put(key, nNode);
                ++count;
                if (count > capacity) {

                    DlinkNode rnode = this.head.popTail(this.tail);
                    this.cache.remove(rnode.key);
                    --count;
                }
            }
            else{
                   node.val = val;
                    this.head.moveToHead(node,this.head);

                }
            }





    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);


    }

}


