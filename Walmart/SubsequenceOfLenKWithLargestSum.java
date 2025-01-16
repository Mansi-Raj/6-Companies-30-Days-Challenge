package Walmart;

import java.util.*;;

public class SubsequenceOfLenKWithLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        k = Math.min(k, n);
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mapList.add(new AbstractMap.SimpleEntry<>(nums[i], i));
        }

        mapList.sort((entry1, entry2) -> Integer.compare(entry2.getKey(), entry1.getKey()));
        List<Map.Entry<Integer, Integer>> topKEntries = mapList.subList(0, k);
        topKEntries.sort((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topKEntries.get(i).getKey();
        }

        return result;
    }
}
