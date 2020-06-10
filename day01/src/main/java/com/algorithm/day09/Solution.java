package com.algorithm.day09;

import com.algorithm.common.TreeNode;
import com.algorithm.day05.Tree;

import java.util.*;
import java.util.logging.Level;

public class Solution {


    /**
     * 前序遍历  先遍历根节点 根 左 右
     *
     * @param node
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        stack.push(curr);
        while (!stack.isEmpty()) {  //先序遍历
            curr = stack.pop();   //弹出头指针  //每次先弹出中间的root节点 后再右边 左边的压进去 //先进后出
            res.add(curr.val); //记录
            if (curr.right != null) {   //遍历右边
                stack.push(curr.right); //压入
            }
            if (curr.left != null) { //遍历左边 //压入
                stack.push(curr.left);
            }
        }
        return res;
    }


    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        res.add(root.val);


        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }

        }

        return res;

    }


    public List<Integer> preorderTraversal2(TreeNode node) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode poll = stack.poll();
            res.add(poll.val);
            if (poll.right != null) {
                stack.add(poll.right);
            }
            if (poll.left != null) {
                stack.add(poll.left);
            }

        }

        return res;

    }

    public List<Integer>preorderTraversal3(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }

        }
        return res;
    }


    public List<Integer>preorderTraversal4(TreeNode node){
        LinkedList<TreeNode>stack=new LinkedList<>();
        List<Integer>res=new ArrayList<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }
            if(treeNode.left!=null){
                stack.add(treeNode.left);
            }

        }
        return res;
    }

    /**
     * 后序遍历递归版
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer>res=new LinkedList<>();
        recursiceNode(res,root);
        return res;
    }

    private void recursiceNode(LinkedList<Integer> res, TreeNode root) {

        if(root==null){
            return;
        }
        recursiceNode(res,root.left);
        recursiceNode(res,root.right);
        res.add(root.val);

    }

    //需要强烈的抽象逻辑
    public List<Integer>posorderTraversalOnStack(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast(); //取得栈底元素 尾巴的元素
            output.push(node.val);  //遍历翻起来
            if(node.left!=null){
                stack.add(node.left); //从尾巴添加
            }
            if(node.right!=null){
                stack.add(node.right); //从尾巴添加
            }
        }
        return output;
    }

    //前序遍历中将  主 左 右
    //我们将前序遍历中插入头的操作 改成插入到尾巴
    //这时我们实现了从右到左扫描的过程 //右左主 将遍历顺序更改的话就可以实现左右根
    List<Integer>postorderTraversalOnStack2(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            res.push(root.val);
            if(root.left!=null){
                stack.add(root.left);
            }
            if(root.right!=null){
                stack.add(root.right);
            }
        }
        return res;

    }

    List<Integer>postorderTraversalOnStack3(TreeNode node){
        LinkedList<TreeNode>stack = new LinkedList<>();
        LinkedList<Integer>res = new LinkedList<>();
        stack.add(node);
        while(stack!=null){
            TreeNode last = stack.pollLast();
            res.addLast(last.val);
            if(last.left!=null){
                stack.add(last.left);
            }
            if(last.right!=null){
                stack.add(last.right);
            }
        }
        return res;
    }


    List<Integer>postorderTraversalOnStack4(TreeNode node){
        LinkedList<TreeNode>stack = new LinkedList<>();
        LinkedList<Integer>res=new LinkedList<>();
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode last = stack.pollLast();
            res.push(last.val);
            if(last.left!=null){
                stack.add(last.left);
            }
            if(last.right!=null){
                stack.add(last.right);
            }
        }
        return res;
    }


    List<Integer>postorderTraversalOnStack(TreeNode node){
        LinkedList<TreeNode>stack = new LinkedList<>();
        LinkedList<Integer>res=new LinkedList<>();
        stack.add(node);
        while (stack!=null){
            node = stack.pollLast();
            res.push(node.val);
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
        }
        return res;
    }
}
