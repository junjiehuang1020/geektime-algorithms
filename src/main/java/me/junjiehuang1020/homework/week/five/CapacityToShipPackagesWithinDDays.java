package me.junjiehuang1020.homework.week.five;

public class CapacityToShipPackagesWithinDDays {
    
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (validate(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    private boolean validate(int[] weights, int days, int weight) {
        
        int neededDay = 0;
        int accumulate = 0;
        
        for (int i = 0; i < weights.length; i++) {
            accumulate += weights[i];
            if (accumulate > weight) {
                accumulate = weights[i];
                neededDay++;
            }
        }
        neededDay++;
        
        return !(neededDay > days);
    }
}
