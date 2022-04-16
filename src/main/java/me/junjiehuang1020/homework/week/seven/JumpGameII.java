package me.junjiehuang1020.homework.week.seven;

public class JumpGameII {
    
    int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
        dp[i] = Integer.MAX_VALUE - 1;
    }
    
    dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (j + nums[j] >= i) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
    }

        return dp[nums.length - 1];
    
}
}
