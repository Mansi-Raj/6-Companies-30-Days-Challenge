package Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> {
            int compFreq = e2.getValue().compareTo(e1.getValue());
            if (compFreq != 0) {
                return compFreq;
            }
            return e1.getKey().compareTo(e2.getKey());
        });
        List<String> result = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Integer> e : list) {
            if (i < k) {
                result.add(e.getKey());
                i++;
            }
        }
        return result;
    }
}
