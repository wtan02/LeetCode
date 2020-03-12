package binarySearch.findFirstBadVersion;

public class Solution implements findFirstBadVersion {
    @Override
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }else {
            return end;
        }
    }
}
