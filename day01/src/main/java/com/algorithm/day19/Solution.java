package com.algorithm.day19;

import java.util.Arrays;

public class Solution {

    public int interval(int [][] points){
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points,(x,y)->{
            return x[1]-y[1];
        });
        int x_end=points[0][1];
        int count=1;
        for(int[] intval:points){
            int start=intval[0];
            if(x_end<start){
                count++;
                x_end=intval[1];
            }

        }
        return count;
    }

}
