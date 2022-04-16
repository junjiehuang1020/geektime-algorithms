package me.junjiehuang1020.homework.week.eight;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        
        dx = new int[]{-1, 0, 0, 1};
        dy = new int[]{0, -1, 1, 0};
        
        fa = new int[m * n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fa[num(i, j)] = num(i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == '1') {
                        unionSet(num(i, j), num(ni, nj));
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && find(num(i, j)) == num(i, j)) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private int m;
    private int n;
    
    private int ans;
    
    private int[] dx;
    private int[] dy;
    
    private int[] fa;
    
    private int find(int x) {
        if (fa[x] == x) {
            return fa[x];
        }
        fa[x] = find(fa[x]);
        return fa[x];
    }
    
    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[y] = x;
        }
    }
    
    private int num(int i, int j) {
        return i * n + j;
    }
}
