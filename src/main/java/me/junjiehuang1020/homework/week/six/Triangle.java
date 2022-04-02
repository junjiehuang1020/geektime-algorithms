package me.junjiehuang1020.homework.week.six;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    
    public int minimumTotal1(List<List<Integer>> triangle) {
        
        int ans = 0;
        int m = triangle.size();
        
        List<Integer> protect = new ArrayList<>();
        
        for (int i = 0; i <= m; i++) {
            protect.add(0);
        }
        triangle.add(protect);
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        
        return triangle.get(0).get(0);
        
    }
    
    // 迭代超时了。
    public int minimumTotal2(List<List<Integer>> triangle) {
        
        return recur(triangle, 0, 0);
        
    }
    
    private int recur(List<List<Integer>> triangle, Integer i, Integer j) {
        
        
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        
        return Math.min(recur(triangle, i + 1, j), recur(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        
    }
}
