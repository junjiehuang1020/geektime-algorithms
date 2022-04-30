package me.junjiehuang1020.homework.week.ten;

import java.util.TreeMap;

public class SlidingWindowMaximum {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        map = new TreeMap<Integer, Integer>();
        
        int[] ans = new int[nums.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        ans[0] = map.lastKey();
        
        for (int i = 1; i <= nums.length - k; i++) {
            
            if (map.get(nums[i - 1]) == 1) {
                map.remove(nums[i - 1]);
            } else {
                map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
            }
            
            if (map.containsKey(nums[k + i - 1])) {
                map.put(nums[k + i - 1], map.get(nums[k + i - 1]) + 1);
            } else {
                map.put(nums[k + i - 1], 1);
            }
            
            ans[i] = map.lastKey();
        }
        
        return ans;
    }
    
    private TreeMap<Integer, Integer> map;
}
