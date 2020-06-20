package com.algorithm.day20;

import java.util.*;

public class Solution {

    int fib(int N){
        if(N<1)return 0;
        //备忘录全初始化为0
        int[]meno=new int[N+1];
        return helper(meno,N);
    }
    int helper(int[] meno,int n){
        //base case
        if(n==1||n==2)return 1;
        //已经计算过
        if(meno[n]!=0)return meno[n];
        meno[n]=helper(meno,n-1)+helper(meno,n-2);
        return meno[n];


    }

    public int fib1(int N) {
        if(N==0){
            return 0;
        }
        int [] dp=new int[N+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=N;i++){
            //自底像上推
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[N];
    }

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map=new HashMap<>();

        return dp(coins,amount,map);
    }

    /**
     * 自顶向下的
     * @param
     * @return
     */
    private int dp(int[] coins,int amount,Map<Integer, Integer> map) {
        if(map.containsKey(amount))return map.get(amount);
        //base case
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        // 求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem=dp(coins,amount-coin,map);
            if(subproblem==-1){
                continue;
            }
            res=Math.min(res,1+subproblem);
        }
        res=res!=Integer.MAX_VALUE? res :-1;
        map.put(amount,res);
        return map.get(amount);
    }



    public int coinChange1(int[] coins, int amount) {
        List<Integer>list= new ArrayList<>(amount+1);
        int[] arr=new int[amount+1];
        Arrays.fill(arr,amount+1);
        arr[0]=0;
        //自底向上
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i <arr.length; i++) {
            //内层循环在求所选择的最小值
            for (int coin:coins){
                //子问题无解
                if(i-coin<0)continue;
                arr[i]=Math.min(arr[i],1+arr[i-coin]);
            }
        }
        return (arr[amount]==amount+1)?-1:arr[amount];
    }

}
