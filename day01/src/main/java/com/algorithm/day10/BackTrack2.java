package com.algorithm.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack2 {
    List<List<Integer>>output=new ArrayList<>();
    int n,k;

    //回溯法是一种探索所有潜在可能性找到解决方案的算法。如果当前方案不是正确的解决方案，或者不是最后一个正确的解决方案，则回溯法通过修改上一步的值继续寻找解决方案。
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        System.out.print(curr.size()+":   k: "+k+"   first:"+first +"   nums:");
        System.out.println(curr);
        //if the combination is done
        if(curr.size()==k){//当计算结束
            output.add(new ArrayList<>(curr));//第一次进入后就会让[]进入
        }
        for (int i = first; i < n; ++i) {//n为3  //递归式保持i不变 ---这里是终止条件 每一层first互不影响   回溯算法控制这里是关键

            //add  i into the current combination
            curr.add(nums[i]);  //[0] [1] [2]  [1,2,3] 1时出来  0-1-2  1-2    1-2-3  2
            //use next integers to complete the combination
            //传过来的first是二 我这边循环后会在开一层出来 因为没有到第三层
            backtrack(i+1,curr,nums);//first自增 curr为上一层传下来的结果集[0]
            System.out.println(curr+":xx:"+i);//递归解除返回层时执行
            //backtrack
            curr.remove(curr.size()-1);//回溯 0  这里删除后 size变了 会一层一层的删完 2-1  删到[1]回到第一层 -----注意此时只是递归层的for循环结束
        }
        System.out.println(curr+":"+k);//递归解除返回层时执行

    }

    //递归
    public  List<List<Integer>>subsets(int[] nums){
        n=nums.length;
        for (k = 0; k < n+1; ++k) {//因为包括[]这种可能性 这里是小于 就是长度为k k是可变的全局变量
            backtrack(0,new ArrayList<Integer>(),nums);//每次创建一个新的结果集
            System.out.println(output+"output");
        }
        return output;
    }


    public static void main(String[] args) {
        BackTrack2 backTrack2 = new BackTrack2();
        int[]nums=new int[]{1,2,3};
        List<List<Integer>> subsets = backTrack2.subsets(nums);
        System.out.println(subsets.toString());
    }
}
