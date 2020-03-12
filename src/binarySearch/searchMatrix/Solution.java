package binarySearch.searchMatrix;

public class Solution implements searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0, end = matrix.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int row;

        if (matrix[start][0] > target) {
            return false;
        } else if (matrix[end][0] > target) {
            row = start;
        } else {
            row = end;
        }

        start = 0;
        end = matrix[row].length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if(matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
}
