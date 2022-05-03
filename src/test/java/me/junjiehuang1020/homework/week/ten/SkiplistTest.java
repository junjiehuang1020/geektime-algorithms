package me.junjiehuang1020.homework.week.ten;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkiplistTest {
    
    @Test
    void test() {
        
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.show();
        skiplist.search(0);
        skiplist.add(4);
        skiplist.show();
        skiplist.search(1);
        skiplist.erase(0);
        skiplist.show();
        skiplist.erase(1);
        //skiplist.show();
        //skiplist.search(1);
        
    }
    
}
