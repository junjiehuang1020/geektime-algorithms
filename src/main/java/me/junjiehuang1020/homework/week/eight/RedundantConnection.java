package me.junjiehuang1020.homework.week.eight;

public class RedundantConnection {
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        fa = new int[n + 1];
        
        // MakeSet
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (find(edges[i][0]) != find(edges[i][1])) {
                unionSet(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        
        return new int[]{0, 0};
    }
    
    private int[] fa;
    
    private int find(int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }
    
    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[y] = x;
        }
    }
}
