package Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharAccToFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> e : mapList) {
            for (int i = 0; i < e.getValue(); i++) {
                result.append(e.getKey());
            }
        }

        return result.toString();
    }
}
