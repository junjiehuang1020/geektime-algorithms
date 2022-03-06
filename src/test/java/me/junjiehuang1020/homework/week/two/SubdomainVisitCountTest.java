package me.junjiehuang1020.homework.week.two;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubdomainVisitCountTest {
    
    String[] cpdomains;
    
    @BeforeEach
    void setUp() {
        cpdomains = new String[]{"9001 discuss.leetcode.com"};
    }
    
    @Test
    void subdomainVisits() {
    
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        subdomainVisitCount.subdomainVisits(cpdomains);
    }
}
