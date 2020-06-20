package com.algorithm.day15;

public class Solution {

    int binarySearch(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;

        while(left<=right){ //终止条件为left=right+1  这个如果使用left<right会漏掉一个既循环不会进入
            int mid=left+(right-left)/2;  //先除2了再加上左边的
            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }

//    寻找左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        if(nums.length==0)return -1;
        int left=0;
        int right=nums.length;

        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                right=mid;  //搜索左边界 不要立即返回,而是缩小搜索区间的上界right 在区间[left ,mid]中继续搜索,即不断向左收缩,达到锁定左边界的目的
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;//搜索区间为左闭右开的
            }
        }
        //return left;  意义为返回的值里小于target的
        if (left >= nums.length || nums[left] != target)return -1;
        return left;

    }


    /**
     * 两边都是闭区间时
     * @param nums
     * @param target
     * @return
     */
    int left_bound1(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(left+right)/2;
            //搜索空间为[]
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                //收缩右边界
                right=mid-1;
            }

        }
        //检查出界情况
        if(left>=nums.length||nums[left]!=target) //由于while的退出条件是left=right+1 当target比所有元素都要大的时候
            return -1;
        return left;
        
    }


    //寻找右侧边界的二分查找
    int right_bound(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length;

        while(left<right){
            int mid=(right+left)/2;
            if(nums[mid]==target){                                                //   [y][l]
                left=mid+1; //增大搜索区间的下界,使得区间不断向右收缩,达到锁定right才对  [x ,x ,x ,x ,x   ]
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }
            //不要后悔啊,虽然对不起大也公司,真的很对不起,也很对不起北斗,也很对不起云里雾里,但是要集中注意力啊,你已经很努力了,真的很努力了,加油好好的吧
        }
        if(left==0)return -1;
        return nums[left-1]==target?(left-1):-1;//为什么没有返回 -1 的操作？如果 nums 中不存在 target 这个值，怎么办？
       // return left-1; //注意 此处的left==right 搜索右侧边界的一个特殊点  mid=left-1  我们对left的更新必须是mid+1 当while结束时,nums[left]一定不等于target了,而nums[left-1]可能是target

    }


    int right_bound1(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                left=mid+1;  //收缩左边界时,必须减+1
            }else if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }
        }
        //检测边界越界right越界
        if (right <0 || nums[right] != target) //当target比所有元素都小时,right会被减到-1
            return -1;
        return right;
    }



    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
         int left=0;
         int right=nums.length-1;

         int[] res=new int[]{-1,-1};
         while(left<=right){
             int mid=left+(left+right)/2;
             if(target==nums[mid]){
                 right=mid-1;
             }else if(target<nums[mid]){
                 right=mid-1;
             }else if(target>nums[mid]){
                 left=mid+1;
             }
         }
         if(left>nums.length||nums[left]!=target)return res;
         res[0]=left;
        while(left<=right){
            int mid=left+(left+right)/2;
            if(target==nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }
        }
        if(right<0||nums[right]!=target)return res;
        res[1]=right;
        return res;
    }


}
