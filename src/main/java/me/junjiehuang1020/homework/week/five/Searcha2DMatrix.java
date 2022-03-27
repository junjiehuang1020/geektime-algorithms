package me.junjiehuang1020.homework.week.five;

public class Searcha2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rowLeft = 0;
        int rowRight = m - 1;
        
        while (rowLeft < rowRight) {
            int mid = (rowLeft + rowRight) / 2;
            if (matrix[mid][n - 1] >= target) {
                rowRight = mid;
            } else {
                rowLeft = mid + 1;
            }
        }
        
        int columnLeft = 0;
        int columnRight = n - 1;
        
        while (columnLeft <= columnRight) {
            int mid = (columnLeft + columnRight) / 2;
            if (matrix[rowRight][mid] == target) {
                return true;
            }
            if (matrix[rowRight][mid] < target) {
                columnLeft = mid + 1;
            } else {
                columnRight = mid - 1;
            }
        }
        
        return false;
        
    }
}
