package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // NOTE: Use sliding window + HashMap to track last seen index of characters.
    // Move start when duplicates found to maintain uniqueness.
    // Time: O(n).

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int curr = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        while (curr < s.length()) {
            char ch = s.charAt(curr);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                int length = curr - 1 - start + 1;
                maxLength = Math.max(maxLength, length);
                start = map.get(ch) + 1;
            }
            map.put(ch, curr);
            curr++;
        }

        int length = curr - start;
        maxLength = Math.max(maxLength, length);
        return maxLength;
    }

}
