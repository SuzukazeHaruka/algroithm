package com.algorithm.day13.Solution;

import com.algorithm.common.TreeNode;
import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.*;

public class Nqueue {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode>deque=new LinkedList<>();
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size=deque.size();//记录每一层的节点数
            for (int i = 0; i < size ; i++) {
                TreeNode pop = deque.pop();
                level.add(pop.val);
                if(pop.left!=null){
                    deque.offer(pop.left);
                }
                if(pop.right!=null){
                    deque.offer(pop.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
