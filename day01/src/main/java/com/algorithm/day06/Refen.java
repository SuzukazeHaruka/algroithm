package com.algorithm.day06;

import java.util.ArrayList;
import java.util.List;

public class Refen {

    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("1");
        List<String> list1 = Refen.find(list);
        System.out.println(list==list1);
    }


    public static List<String> find (List<String> list){
        list=new ArrayList<>();
        list.add("2");
        return list;
    }

    


}
