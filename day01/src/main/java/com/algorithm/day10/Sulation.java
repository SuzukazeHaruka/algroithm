package com.algorithm.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sulation {


    //快速幂 加递归
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数
    //不适用库函数
    public static double quickMul(double x, long N) {
        //终止条件 当下降到0次方时,可以确定一个数
        if(N==0){
            return 1.0;
        }
        //-------------------------这里回进行回溯 每次返回都携带下一层的结果回来
        double y=quickMul(x,N/2); //递归开始 //分治
        return N%2==0?y*y:y*y*x; //执行逻辑   //最终1*x x的值始终没有变化
    }
    public double myPow(double x,int n){
        long N=n;
        return N>=0?quickMul(x,N):1.0/quickMul(x,-N);  //判断指数的正负
    }

    public static void main(String[] args) {
        Sulation.quickMul(2,12);

    }



}
