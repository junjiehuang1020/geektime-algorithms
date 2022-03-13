package me.junjiehuang1020.homework.week.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseSchedule2Test {
    
    @Test
    void findOrder() {
        
        int numCourses = 4;
        
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
    
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        courseSchedule2.findOrder(numCourses, prerequisites);
    }
}
