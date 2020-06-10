package com.algorithm.day02;

import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        MinStack.threeSum(nums);
    }



}
class Solution{
    private static final Map<Character, Character>map=new HashMap<Character, Character>(){
        {put('{','}');put('[',']');put('(',')');put('?','?');
    }};
    public  static boolean isValid(String s){
        if(s.length()>0&& ! map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character>stack=new LinkedList<Character>(){{add('?');}};
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.addLast(c);
            }
            else if(map.get(stack.removeLast())!=c) {
                return false;
            }
        }
        return stack.size()==1;

    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || x <= min_stack.peek()) {
            min_stack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new LinkedList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length-2; l++) {
            if(nums[l]>0){
                break;
            }
            if(l>0&&nums[l]==nums[l-1]){
                continue;
            }
            int i=l+1;int j=nums.length-1;
            while (i<j){
                int sum=nums[l]+nums[i]+nums[j];
                if(sum<0){
                    while (i<j&&nums[i]==nums[++i]);
                }else if(sum>0){
                    while(i<j&&nums[j]==nums[--j]);
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[l],nums[i],nums[j])));
                    while (i<j&&nums[i]==nums[++i]);
                    while (i<j&&nums[j]==nums[--j]);
                }

            }
        }

        return res;
    }

}
