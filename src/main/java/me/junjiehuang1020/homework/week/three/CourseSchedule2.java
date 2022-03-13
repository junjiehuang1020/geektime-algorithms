package me.junjiehuang1020.homework.week.three;

import java.util.*;

public class CourseSchedule2 {
    
    private Map<Integer, List<Integer>> to;
    
    private Map<Integer, Integer> inDegrees;
    
    private Queue<Integer> queue;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    
        to = new HashMap<>();
        inDegrees = new HashMap<>();
        queue = new LinkedList<>();
        
        for (int[] prerequisite: prerequisites) {
            
            final int a = prerequisite[0];
            final int b = prerequisite[1];
            
            if (!to.containsKey(b)) {
    
                List<Integer> edges = new ArrayList<>();
                
                edges.add(a);
                to.put(b, edges);
                
            } else {
                
                List<Integer> edges = to.get(b);
                
                edges.add(a);
                to.put(b, edges);

            }
            
            if (!inDegrees.containsKey(a)) {
                inDegrees.put(a, 1);
            } else {
                Integer inDegree = inDegrees.get(a);
                inDegree++;
                inDegrees.put(a, inDegree);
            }
        }
    
        for (int i = 0; i < numCourses; i++) {
            
            if (!inDegrees.containsKey(i)) {
                queue.offer(i);
            }
            
        }
    
        List<Integer> visited = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            
            Integer x = queue.poll();
            visited.add(x);
            
            if (to.get(x) == null) {
                continue;
            }
            
            for (Integer y : to.get(x)) {
                Integer degree = inDegrees.get(y);
                degree--;
                inDegrees.put(y, degree);
                if (degree == 0) {
                    queue.offer(y);
                }
            }
            
        }
        
        if (visited.size() != numCourses) {
            return new int[0];
        }
    
        int[] ans = new int[visited.size()];
    
        for (int i = 0; i < visited.size(); i++) {
            ans[i] = visited.get(i);
        }
        
        return ans;
    
    }
}
