package me.junjiehuang1020.homework.week.one;

public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
    
        for (int k = digits.length - 1; k >= 0; k--) {
            if (digits[k] == 9) {
                if (k == 0) {
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    return ans;
                }
                digits[k] = 0;
            } else {
                digits[k] += 1;
                break;
            }
        }
    
        return digits;
    }
}
