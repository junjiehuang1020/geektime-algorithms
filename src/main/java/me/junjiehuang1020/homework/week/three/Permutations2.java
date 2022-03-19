package me.junjiehuang1020.homework.week.three;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    
    private List<List<Integer>> ans;
    
    private List<Integer> chosen;
    
    private List<Integer> indexs;
    
    private int n;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        ans = new ArrayList<>();
        chosen = new ArrayList<>();
        indexs = new ArrayList<>();
        n = nums.length;
        
        recur(nums, n, indexs);
        
        return ans;
        
    }
    
    private void recur(int[] nums, int n, List<Integer> indexs) {
        
        if (chosen.size() == n) {
            if (!ans.contains(chosen)) {
                ans.add(new ArrayList<>(chosen));
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (!indexs.contains(i)) {
                chosen.add(nums[i]);
                indexs.add(i);
            } else {
                continue;
            }
            
            recur(nums, n, indexs);
            
            chosen.remove(chosen.size() - 1);
            indexs.remove(indexs.size() - 1);
            
        }
    }


}
