package com.algorithm.day03;



import java.util.ArrayDeque;
import java.util.Stack;

public class TestAlgorithm {


    public static void main(String[] args) {
        int [] nums=new int [] {1,3,-1,-3,5,3,6,7};
        maxSlidingWindowForDeque(nums,3);
    }

    public static int largestRectangleArea(int[] heights) {
        int maxarea=0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {//从i开始遍历 找到左边界 //i为左指针 j为右指针
                int minHeight=Integer.MAX_VALUE;//初始化Integer的最大值
                for (int k = i; k <=j ; k++) {//
                    minHeight=Math.min(minHeight,heights[k]);//找到最小的高度//决定面积的是最小高度
                    maxarea=Math.max(maxarea,minHeight*(j-i+1));//最大面积,数组是从0开始的但是0下标本身宽度就为1
                }
            }
        }
        return maxarea;
    }

    //双指针解法
    public static int largestRectangleArea1(int[] heights) {
        int maxarea=0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight=Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
               minHeight= Math.min(minHeight,heights[j]);
               maxarea=Math.max(maxarea,minHeight*(j-i+1));
            }
        }
        return maxarea;
    }

    public int largestRectangleAreaStack(int[] heights) {
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        int maxarea=0;
        for (int i = 0; i < heights.length; i++) {
            //将数组中的元素按小到大的顺序插入栈中,然后遍历元素时,可以确定左边的元素(左边界),
            // 当右边的元素小于栈顶元素时,可以确定右边界,其左边界就是小于或者有边界的那个值,
            while (stack.peek()!=-1&&heights[stack.peek()]>=heights[i])
                //出栈栈顶元素,计算最大面积,因为是求中间的面积所以要减1
                //然后一直循环找到左边界求出最大的面积
                maxarea=Math.max(maxarea,heights[stack.pop()])*(i-stack.peek()-1);
            stack.push(i);
        }
        //当遍历元素,栈中还有元素时,直接出栈,计算面积,宽为数组的长度减去栈顶元素的下标减一
        while (stack.peek()!=-1)
            maxarea=Math.max(maxarea,heights[stack.pop()]*(heights.length-stack.peek()-1));
            return maxarea;

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n*k==0)return new int [0];
        int [] output=new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {//循环3个数,找到他们中最大值
            int max=Integer.MIN_VALUE;
            for (int j = i  ; j < i+k; j++) {
                max=Math.max(max,nums[j]);
            }
            output[i]=max;
        }
        return output;
    }




    public static int[] maxSlidingWindowForDeque(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int n=nums.length;
        if(n*k==0)return new int[0];
        if(k==1)return nums;
        //init deque and output
        int max_idx=0;
        for (int i = 0; i < k; i++) {//防止数组下标越界
            clean_deque(i,k,deq,nums);
            deq.addLast(i);//队列中只保存最大值的索引
            // compute max in nums[:k]
            if(nums[i]>nums[max_idx])max_idx=i;
        }
        int [] output=new int[n-k+1];
        output[0]=nums[max_idx];//记录第一个下标决定前三个的最大值

        for (int i = k; i < n; i++) {
            clean_deque(i,k,deq,nums);
            deq.addLast(i);
            output[i-k+1]=nums[deq.getFirst()];//最大值放在最左边的 每次右移动时[决定最大值]
        }
        return output;
    }
    //只保留当前滑动窗口中有的元素的索引。
    //  - 移除比当前元素小的所有元素，它们不可能是最大的。
    public static void clean_deque(int i,int k,ArrayDeque<Integer> deq,int [] nums){
        //从滑动窗口中删除元素的索引
        if(deq.size()>0){
            Integer first = deq.getFirst();
            Integer last = deq.getLast();
        }
        //前面的两个值与后面的两个值 共享中间的最大值  [1,2,6,3,4]
        if (!deq.isEmpty() && deq.getFirst()==i-k){  //当前索引-k等于第一个存进来的索引 第一个存的1 4-3
            deq.removeFirst();
            //双端队列头和尾不要产生狭义
        }

        //从所有deq索引元素的中删除
        //小于当前元素

        while (!deq.isEmpty()&&nums[i]>nums[deq.getLast()])//当前元素于队列中最后一个元素
            //如果包含这个最大值的3个数
            deq.removeLast();
    }



}




class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
}

