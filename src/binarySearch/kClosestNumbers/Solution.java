package binarySearch.kClosestNumbers;

public class Solution implements kClosestNumbers{
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if (A == null || A.length == 0 || k == 0) {
            return new int[0];
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
        int closest = Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;

        int[] result = new int[k];
        int left = closest - 1, right = closest + 1;
        result[0] = A[closest];
        for (int i = 1; i < k; i ++) {
            if (left >= 0 && right < A.length) {
                if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                    result[i] = A[left];
                    left--;
                }
                else {
                    result[i] = A[right];
                    right++;
                }
            } else {
                if (left >= 0) {
                    result[i] = A[left--];
                }
                if (right < A.length) {
                    result[i] = A[right++];
                }
                if (left < 0 && right > A.length) {
                    break;
                }
            }
        }

        return result;
    }

}
