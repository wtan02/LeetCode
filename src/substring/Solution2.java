package substring;

import java.util.Arrays;
import java.util.Comparator;

class Pair{
    //Accumulated Sum till index
    int sum;
    int indexPlusOne;
    public Pair(int sum, int indexPlusOne) {
        this.sum = sum;
        this.indexPlusOne = indexPlusOne;
    }
}
public class Solution2 implements SubarraySumClosest {
    public int[] subarraySumClosest(int[] nums){
        int[] res = new int[2];
        Pair[] accumulatedSums = new Pair[nums.length + 1];
        accumulatedSums[0] = new Pair(0,0);

        for (int i = 1; i < nums.length + 1; i ++){
            accumulatedSums[i] = new Pair(accumulatedSums[i - 1].sum + nums[i - 1], i);
        }

        Arrays.sort(accumulatedSums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });

        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i < accumulatedSums.length; i++) {
            if (accumulatedSums[i].sum - accumulatedSums[i - 1].sum < minSum) {
                minSum = accumulatedSums[i].sum - accumulatedSums[i - 1].sum;
                int[] temp = new int[]{accumulatedSums[i].indexPlusOne - 1, accumulatedSums[i - 1].indexPlusOne - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }
}
