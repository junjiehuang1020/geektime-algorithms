package me.junjiehuang1020.homework.week.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {
    
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        List<Integer> degreeNums = new ArrayList<>();
        
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                Integer count = map.get(num);
                count++;
                map.put(num, count);
            }
        }
        
        Integer degree = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            degree = Math.max(degree, entry.getValue());
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            
            if (entry.getValue().equals(degree)) {
                degreeNums.add(entry.getKey());
            }
            
        }
        
        Integer ans = Integer.MAX_VALUE;
        
        for (Integer degreeNum: degreeNums) {
            Integer first = 0;
            Integer last = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == degreeNum) {
                    first = i;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == degreeNum) {
                    last = j;
                    break;
                }
            }
            ans = Math.min(ans, last - first + 1);
        }
        
        return ans;
        
    }
}
