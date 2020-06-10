package com.algorithm.day05;




import lombok.Data;


import java.util.LinkedList;
import java.util.List;
//中序遍历
//先遍历左边的在遍历右边的
public class Tree {


    public List<Integer>inorderTraversal(TreeNode root){
        List<Integer>res=new LinkedList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root!=null){
            if(root.left!=null){
                helper(root.left,res);
            }
            res.add(root.val);
            if(root.right!=null){
                helper(root.right,res);
            }
        }
    }


    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>res=new LinkedList<>();
        helperOfFront(root,res);
        return res;
    }

    public void helperOfFront(TreeNode root,List<Integer>res){
        if(root!=null) {


            res.add(root.val);
            if (root.left != null) {
                helperOfFront(root.left, res);
            }
            if (root.right != null) {
                helperOfFront(root.right, res);
            }
        }

    }

}





@Data
class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public Integer val;
}
