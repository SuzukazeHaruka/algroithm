package com.algorithm.day07;

import org.junit.Test;

import java.util.*;

public class HeapDemo {


//时间复杂度分析 由于使用一个大小为k的堆,所以空间复杂度是O(k)
//    时间复杂度是O(nlogK) 堆1的插入为O(logK)
//    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//    最小的数字,而非数字组合

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        //java的PriorityQueue默认是小顶堆,添加comparator参数使其变成最大堆
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((x,y)->y-x);
        for (int i : arr) {
            //当前元素小于堆顶元素才会入堆
            if(heap.isEmpty()||heap.size()<k||i<heap.peek()){
                heap.offer(i);
            }
            if(heap.size()>k){
                heap.poll();//删除堆顶元素1
            }
        }
        //将堆中元素存入数组中
        int[] res=new int[heap.size()];
        int j=0;
        for (Integer e : heap) {
            res[j++]=e;
        }
       return res;
    }

    /**
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *[1,3,-1,-3,5,3,6,7]
     * 3
     * @param nums
     * @param k
     * @return
     */

   static  public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int [nums.length-k+1]; //创建长度是数组长度
        int j=0;
        if(k==0){
            return new int[0];
        }
        LinkedList stack = new LinkedList();//用来记录下标
        PriorityQueue<Integer> head = new PriorityQueue<Integer>((x,y)->y-x);
        for (int i = 0; i < nums.length; i++) {

            if(head.isEmpty() || head.size()<k ){
                head.offer(nums[i]);
            }
            if(head.size()==k){
                res[j++]=head.peek();
                head.remove(nums[i-(k-1)]);//移除不在滑动窗口中元素  i从零开始(所以k)
            }

        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k=1;
        for (int i : HeapDemo.maxSlidingWindow(nums, k)) {
            System.out.println(i);
        }


        int[] ints = HeapDemo.topKFrequent(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt+":ss");
        }

        HeapDemo.print2n(2);

    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int e : nums) {
            count.put(e, count.getOrDefault(Integer.valueOf(e), 0) + 1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((x,y)->count.get(x)-count.get(y));//重写比较器,比较值
        for (Integer n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {//进入空间中的数满了,小顶堆,那么移除最小的这个
                heap.poll();
            }

        }
        List<Integer> list = new ArrayList<>();
        int j = 0;
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        int[] arr=new int[list.size()];
        for (Integer integer : list) {
            arr[j++]=integer;
        }
        return arr;
    }



    public static void print2n(int n){
        System.out.println(n);
        if(n>8000){
            System.out.println(n);
            return;
        }
        print2n(2*n);
        System.out.println(n);
    }


    }
