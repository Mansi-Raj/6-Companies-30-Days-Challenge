package Google;

import java.util.*;

public class NeighborhoodRearrangement {
    static int[][] neighborhoodRearranger(int[][] houses, char[][] colors) {
        int rows = houses.length;
        List<Map.Entry<Integer, Character>> pair = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < houses[i].length; j++) {
                pair.add(new AbstractMap.SimpleEntry<>(houses[i][j], colors[i][j]));
            }
        }
        Collections.sort(pair, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> entry1, Map.Entry<Integer, Character> entry2) {
                return Integer.compare(entry1.getKey(), entry2.getKey());
            }
        });

    }
}