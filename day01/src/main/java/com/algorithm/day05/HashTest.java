package com.algorithm.day05;



import java.lang.reflect.Array;
import java.util.*;

public class HashTest {
    public static void main(String[] args) {

    }

    public int [] twoSum(int []nums,int target){
        Map<Integer, Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement  = target - nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){ //判断不是当前的下标
                return new int[]{i,map.get(complement)};
            }

        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public int[] twoSumOfOneTimes(int[] nums, int target) {
        Map<Integer, Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);

        }

        throw new IllegalArgumentException(("no two sum solution"));


    }

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
      return   Arrays.equals(sarr,tarr);
    }

    public boolean isAnagramForHash(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] counter=new int [26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for (int count : counter) {
                if(count!=0){
                    return false;
                }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)return new ArrayList<>();
        HashMap<String, List> ans = new HashMap<String,List>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!ans.containsKey(key)) ans.put(key,new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }



}
