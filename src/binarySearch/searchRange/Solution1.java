package binarySearch.searchRange;

public class Solution1 implements searchRange{
    @Override
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }

        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int[] result = new int[2];
        if (A[start] == target) {
            result[0] = start;
        } else if (A[end] == target) {
            result[0] = end;
        } else {
            return new int[]{-1, -1};
        }

        int i = result[0];
        while(i < A.length && A[i] == target) {
            i++;
        }

        if (i == result[0]) {
            result[1] = i;
        } else {
            result[1] = i-1;
        }
        return result;
    }
}
