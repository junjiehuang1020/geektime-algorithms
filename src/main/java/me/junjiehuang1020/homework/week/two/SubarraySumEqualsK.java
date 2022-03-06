package me.junjiehuang1020.homework.week.two;

public class SubarraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        
        int[] preSums = new int[nums.length + 1];
        
        for (int i = 1; i <= nums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
        
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSums[i] - preSums[j] == k) {
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
