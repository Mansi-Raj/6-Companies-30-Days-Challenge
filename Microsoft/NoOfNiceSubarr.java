package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class NoOfNiceSubarr {
    public int numberOfSubarrays(int[] nums, int k) {
        int noOfSubarr = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int prefixSum = 0;

        for (int n : nums) {
            prefixSum += n;

            if (prefixSumMap.containsKey(prefixSum - k)) {
                noOfSubarr += prefixSumMap.get(prefixSum - k);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return noOfSubarr;
    }
}
