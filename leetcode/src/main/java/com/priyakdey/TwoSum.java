package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TwoSum {

    // NOTE: Use a HashMap to store num → index while iterating; for each number, check if its
    // complement (target - num) already exists.
    // O(n) time, single-pass solution.

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int compliment = target - num;
            if (seen.containsKey(compliment)) {
                return new int[]{seen.get(compliment), i};
            }
            seen.put(num, i);
        }

        return new int[0];  // unreachable if input is valid
    }

}
