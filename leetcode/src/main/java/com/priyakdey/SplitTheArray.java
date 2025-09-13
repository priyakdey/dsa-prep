package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class SplitTheArray {

    // NOTES:
    // If array length is odd → return false.
    // Build frequency map; if any number appears > 2, return false.
    // Otherwise, return true.
    //
    // Time: O(n), Space: O(n)

    public boolean isPossibleToSplit(int[] nums) {
        int length = nums.length;
        if ((length & 1) != 0) return false;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if (freqMap.get(num) > 2) {
                return false;
            }
        }

        return true;
    }

}
