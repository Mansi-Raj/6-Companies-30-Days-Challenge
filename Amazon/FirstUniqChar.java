package Amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : charArray) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (freq.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}