package me.junjiehuang1020.homework.week.one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    
    public static int maximalRectangle(char[][] matrix) {
    
        int ans = 0;
    
        int rowNumber = matrix.length;
    
        int columnNumber = matrix[0].length;
    
        for (int i = 0; i < rowNumber; i++) {
            int[] heights = new int[columnNumber];
            for (int j = 0; j < columnNumber; j++) {
                int height = 0;
                for(int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '1'){
                        height++;
                    } else {
                        heights[j] = height;
                        break;
                    }
                    heights[j] = height;
                }
            }
        
            ans = Math.max(ans, largestRectangleArea(heights));
        
        }
    
        return ans;


    }

    private static int largestRectangleArea(int[] heights) {

        //暴力遍历法, 这边可以用单调栈优化一下。TODO
        int ans = 0;
    
        int[] exHeights = new int[heights.length + 2];
    
        System.arraycopy(heights, 0, exHeights, 1, heights.length);
    
        for (int i = 0; i < exHeights.length; i++) {
        
            int left = 0;
            int right = 0;
        
            int height = exHeights[i];
        
            for (int j = i - 1; j >= 0; j--) {
                if (exHeights[j] < height) {
                    left = j + 1;
                    break;
                }
            }
        
            for (int k = i + 1; k < exHeights.length; k++) {
                if (exHeights[k] < height) {
                    right = k;
                    break;
                }
            }
        
            ans = Math.max(ans, height * (right - left));
        }
    
        return ans;

    }
}
