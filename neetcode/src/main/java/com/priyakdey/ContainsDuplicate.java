package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ContainsDuplicate {

    // Given an integer array nums, return true if any value appears more than once in the array,
    // otherwise return false.

    // Use a HashSet to track seen numbers.

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

}
