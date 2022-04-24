package me.junjiehuang1020.homework.week.nine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    
    public int firstUniqChar(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            
            if (!map.containsKey(s.charAt(i))) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(1);
                map.put(s.charAt(i), list);
            } else {
                Integer count = map.get(s.charAt(i)).get(1);
                count++;
                map.get(s.charAt(i)).set(1, count);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().get(1) == 1) {
                ans = Math.min(ans, entry.getValue().get(0));
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private Map<Character, List<Integer>> map;
}
