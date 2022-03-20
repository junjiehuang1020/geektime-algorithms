package me.junjiehuang1020.homework.week.four;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    
    public void solve(char[][] board) {
        
        this.board = board;
        
        m = board.length;
        n = board[0].length;
    
        int color = 1;
        
        dx = new int[]{-1, 0, 0, 1};
        dy = new int[]{0, 1, -1, 0};
        
        // 染色
        colored = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colored[i][j] = 0;
            }
        }
        
        // 记录哪些颜色是不被captured
        uncaptured = new ArrayList<>();
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && colored[i][j] == 0) {
                    colored[i][j] = color;
                    dfs(i, j, color);
                    color++;
                }
            }
        }
        
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (colored[i][j] != 0 && !uncaptured.contains(colored[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    private char[][] board;
    private int[][] colored;
    
    private int m;
    private int n;
    
    // 方向数组
    private int[] dx;
    private int[] dy;
    
    private List<Integer> uncaptured;
    
    private void dfs(int x, int y, int c) {
        
        for (int i = 0; i < 4; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!valid(nx, ny)) continue;
            if (colored[nx][ny] != 0) continue;
            if (board[nx][ny] == 'X' && colored[nx][ny] == 0) continue;
            if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                if (!uncaptured.contains(c)) {
                    uncaptured.add(c);
                }
            }
            colored[nx][ny] = c;
            dfs(nx, ny, c);
            
        }
    }
    
    private boolean valid(int nx, int ny) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }
}
