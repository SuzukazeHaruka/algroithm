package com.algorithm.day17;

import com.algorithm.common.ListNode;
import com.algorithm.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {

    boolean hasCycle(ListNode head){
        ListNode fast ,slow;
        fast=slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }


    public List<Integer> preorder(Node root) {
        LinkedList<Node>stack=new LinkedList<>();
        LinkedList<Integer>res=new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node poll = stack.poll();
            res.add(poll.val);
            if(poll.children !=null){
                for (Node child : poll.children) {
                    stack.push(child);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {


    }


    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        }catch(InterruptedException e){}
    }

    public static void res(String s){
        s.replaceAll("x","y");
    }





}
