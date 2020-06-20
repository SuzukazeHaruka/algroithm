package com.algorithm.day15;

public class Solution2 {

    public int[] searchRange(int[] nums, int target) {

        int left=left_bound(nums,target);
        int right=right_bound(nums,target);
        return new int[]{left,right};
    }

    public int left_bound(int[] nums,int target){
        if(nums.length==0){
            return -1;
        }
        int left =0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }
        }
        if(left>=nums.length||nums[left]!=target)return -1;
        return left;
    }

    public int right_bound(int[] nums,int target){
        if(nums.length==0){
            return -1;
        }
        int left =0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                left=mid+1;
            }else if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }
        }
        if(right<0||nums[right]!=target)return -1;
        return right;
    }
}
