package me.junjiehuang1020.homework.week.six;

public class ClimbingStairs {
    
    public int climbStairs(int n) {
        
        int[] record = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                record[i] = 1;
            } else if (i == 2) {
                record[i] = 2;
            } else {
                record[i] = record[i - 1] + record[i - 2];
            }
        }
        return record[n];
        
    }
}
