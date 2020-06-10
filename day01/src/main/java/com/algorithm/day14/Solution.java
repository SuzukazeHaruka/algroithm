package com.algorithm.day14;

import java.security.PublicKey;
import java.util.*;

public class Solution {


    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     *
     */
    public String plusOne(String s,int i){
        char[] ch = s.toCharArray();
        if(ch[i]=='9'){
            ch[i]='0';
        }
        else
         ch[i]+=1;
        return new String(ch);
    }

    public String minusOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='0'){
            ch[j]='9';
        }else {
            ch[j]-=1;
        }
        return new String(ch);
    }


    public int openLock(String[] deadends, String target) {

        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        //记录以及穷举过的密码,防止走回头路
        Set<String>visited =new HashSet<>();
        Deque<String>deque=new LinkedList<>();
        //从起点开始扩散
        int step=0;
        deque.offer("0000");
        visited .add("0000");
        while (!deque.isEmpty()) {
            int sz = deque.size();
            /**
             * 将当前的节点像四周扩散
             */
            for (int i = 0; i < sz; i++) {


                String cur = deque.poll();
                /**
                 * 判断是否到达终点
                 */
                if (deads.contains(cur)) {
                    continue;
                }
                /**
                 * 到达终点,返回最短路径
                 */
                if (cur.equals(target)) {
                    return step;
                }
                /**
                 * 水平扩散
                 */
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(cur, j);
                    if (!visited.contains(plusOne)) {
                        deque.offer(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(cur, j);
                    if (!visited.contains(minusOne)) {
                        deque.offer(minusOne);
                        visited.add(minusOne);
                    }
                }

            }
            step++;
        }
        return -1;
    }

}
