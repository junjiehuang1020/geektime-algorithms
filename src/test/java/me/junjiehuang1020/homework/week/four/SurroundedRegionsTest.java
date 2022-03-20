package me.junjiehuang1020.homework.week.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {
    
    @Test
    void solve() {
    
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
    
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        
        surroundedRegions.solve(board);
        
    }
}
