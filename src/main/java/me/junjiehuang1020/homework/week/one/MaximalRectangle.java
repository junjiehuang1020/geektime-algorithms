package me.junjiehuang1020.homework.week.one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    
    public static int maximalRectangle(char[][] matrix) {

        //TODO

        return 0;


    }

    private int largestRectangleArea(int[] heights) {

        //TODO
        int ans = 0;

        Deque<Integer> stack = new LinkedList<>();

        int[] extendHeights = new int[heights.length + 2];

        extendHeights[0] =0;

        extendHeights[heights.length + 1] = 0;

        System.arraycopy(heights, 0, extendHeights, 1, heights.length);

        for (int height : extendHeights) {

            while (!stack.isEmpty() && stack.peek() > height) {



                stack.pop();

            }

            stack.push(height);

        }

        return ans;

    }
}
