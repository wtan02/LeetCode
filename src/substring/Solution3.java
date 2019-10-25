package substring;

import java.util.TreeMap;

public class Solution3 implements SubarraySumClosest {
    @Override
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> preSumIndexMap = new TreeMap<>();
        preSumIndexMap.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSumIndexMap.containsKey(preSum)) {
                res[0] = preSumIndexMap.get(preSum) + 1;
                res[1] = i;
                return res;
            }

            Integer greaterPreSum = preSumIndexMap.higherKey(preSum);
            if(greaterPreSum != null && (greaterPreSum - preSum < min)) {
                min = greaterPreSum - preSum;
                res[0] = preSumIndexMap.get(greaterPreSum) + 1;
                res[1] = i;
            }

            Integer lowerPreSum = preSumIndexMap.lowerKey(preSum);
            if(lowerPreSum != null && (preSum - lowerPreSum < min)) {
                min = preSum - lowerPreSum;
                res[0] = preSumIndexMap.get(lowerPreSum) + 1;
                res[1] = i;
            }
            preSumIndexMap.put(preSum, i);
        }
        return res;
    }
}
