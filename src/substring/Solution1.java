package substring;

public class Solution1 implements SubarraySumClosest {
    @Override
    public int[] subarraySumClosest(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int[] res = new int[2];


        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
