package com.algorithm.day05;

import java.util.*;


//先序遍历
public class PreorderTracersal {

    //从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
    public List<Integer> preorderTracersal(TreeNode root){
        LinkedList<TreeNode>stack=new LinkedList<>();
        LinkedList<Integer>output=new LinkedList<>();
        if(root==null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }
        return output;
    }


    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root==null){
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node child : node.children) {
                if(child!=null){
                    stack.add(child);
                }
            }

        }
        return output;
    }
    //前序遍历
    public List<Integer> preorder(Node root) {
        LinkedList<Node>stack=new LinkedList<>();
        LinkedList<Integer>output=new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                if(child!=null){
                    stack.add(child);
                }
            }
        }


        return output;
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer>level = new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }


    }


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}


