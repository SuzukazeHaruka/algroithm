package com.algorithm.day18;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Solution {


    /**
     * 言归正传，本文解决一个很经典的贪心算法问题 Interval Scheduling（区间调度问题）。
     * 给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
     * 也许我们可以每次选择可选区间中开始最早的那个？但是可能存在某些区间开始很早，但是很长，使得我们错误地错过了一些短的区间。
     * 或者我们每次选择可选区间中最短的那个？或者选择出现冲突最少的那个区间？这些方案都能很容易举出反例，不是正确的方案。
     * 从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
     * 把所有与 x 区间相交的区间从区间集合 intvs 中删除。
     * 重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
     */
    public int intervalSchedule(int[][] intvs) {
        if(intvs.length==0)return 0;
        //按end升序排序
        Arrays.sort(intvs,(x,y)->x[1]-y[1]);
        //至少有一个区间相交
        int count=1;
        //排序后,第一个区间就是x
        int x_end=intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if(start>=x_end){
                //找到下一个区间
                count++;
                x_end=interval[1];
            }
        }
        return count;
    }


    public static void main(String[] args) {

        String test = test();
        System.out.println(test);

        while(1==1);
    }

    public static String test(){

        CompletableFuture.supplyAsync(()->{

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xx");
            return "1";
        }).thenAccept(s -> {
            System.out.println(1);;});
        return "3";
    }

}
