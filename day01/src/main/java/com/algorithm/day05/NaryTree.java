package com.algorithm.day05;

import java.util.LinkedList;
import java.util.List;

public class NaryTree {





}


//后序排序 左 右 root
//中序 左 root 右
//前序 root 左 右
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public List<Integer> postorder(Node root) {
         List<Integer>res=new LinkedList<>();
         heleper(res,root);
         return res;
    }


   public void heleper(List<Integer>res, Node root){
        if(root !=null){
            res.add(root.val);
            if(root.children!=null){
                for (Node child : root.children) {
                    heleper(res,child);
                }
            }
        }
   }




};