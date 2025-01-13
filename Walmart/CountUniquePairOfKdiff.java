package Walmart;

import java.util.HashMap;
import java.util.Map;

public class CountUniquePairOfKdiff {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int countPair = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (k == 0) {
                if (e.getValue() > 1) {
                    countPair++;
                }
            } else {
                int n = e.getKey();
                if (freq.containsKey(n + k)) {
                    countPair++;
                }
            }
        }
        return countPair;
    }
}
