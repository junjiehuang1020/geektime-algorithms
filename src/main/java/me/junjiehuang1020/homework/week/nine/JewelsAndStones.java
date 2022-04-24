package me.junjiehuang1020.homework.week.nine;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    
    public int numJewelsInStones(String jewels, String stones) {
        
        jewelsSet = new HashSet<>();
        
        for(char ch: jewels.toCharArray()) {
            
            jewelsSet.add(ch);
        }
        
        int ans = 0;
        for (char ch: jewels.toCharArray()) {
            if (jewelsSet.contains(ch)){
                ans++;
            }
        }
        
        return ans;
        
    }
    
    private Set<Character> jewelsSet;
}
