package com.algorithm.day08;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    //242 .有效的字母异味词
    //输入: s = "anagram", t = "nagaram"
    //输出: true
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    //你可以假设字符串只包含小写字母。

    //时间复杂度分析
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] count=new int [26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }

    
}
