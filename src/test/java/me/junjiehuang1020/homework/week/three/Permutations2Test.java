package me.junjiehuang1020.homework.week.three;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Permutations2Test {
    
    @Test
    void permuteUnique() {
        
        int[] nums = {1, 1, 2};
    
        Permutations2 permutations2 = new Permutations2();
        List<List<Integer>> lists = permutations2.permuteUnique(nums);
    }
}
