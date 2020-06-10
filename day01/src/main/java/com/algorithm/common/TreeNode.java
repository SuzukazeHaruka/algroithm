package com.algorithm.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val ;
    public TreeNode left,right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }


    public static void preorder(){

    }


    public static void inorder(){

    }

    public static void postorder(){

    }


    /**
     * 递归写法 ---中序遍历 //左中右 深度优先
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        recursivePre(res,root);
        return res;

    }



    public void recursivePre(List<Integer>res,TreeNode root){
        //找到深度最深的节点
       if(root!=null){
           if(root.left!=null){
               recursivePre(res,root.left);
           }
       }
       //找到叶子后开始添加
        res.add(root.val);
       //开始遍历右子数
        if(root.right!=null){
            recursivePre(res,root.right);
        }
    }

    //使用栈的方式进行中序遍历 //每一层都是左 根 右
    public List<Integer> inorderTraversalOfStack(TreeNode treeNode ){
        List<Integer>res=new ArrayList<>();
        LinkedList<TreeNode>stack = new LinkedList<>();
        TreeNode curr=treeNode;
        while (curr!=null || ! stack.isEmpty()){ //外层循环,后置循环遍历右子树  //如果右子树为空 需要判断栈中的元素是否还有
            while (curr!=null){//内层循环,遍历左子树深度优先 DSF
                stack.push(curr); //每进入新的一层把遍历的路径放入stack中
                curr=curr.left; //开始跑动 //左边的节点可以把他当做root不要与上一层有牵挂,不然容易混
            }
             curr = stack.pop(); //找到最左边的没有左节点的节点root
            res.add(curr.val);//添加
            curr=curr.right;//遍历他的右边
        }
        return res;
    }



    //5遍刷题法
    public List<Integer>inorderTraversalOfStack1(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr=root;
        while (!stack.isEmpty() && curr!=null ){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }


    public List<Integer>inorderTraverSalOfStack2(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer>res=new ArrayList<>();
        TreeNode curr=root;
        while (!stack.isEmpty() || curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            TreeNode node = stack.pop();
            curr=curr.right;
        }
        return res;
    }
}
