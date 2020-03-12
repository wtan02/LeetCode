package binarySearch.searchMatrix;

public class Solution2 implements searchMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0, column = matrix[0].length, end = matrix.length * column - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid/column][mid%column] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if(matrix[start/column][start%column] == target || matrix[end/column][end%column] == target){
            return true;
        } else {
            return false;
        }
    }
}
