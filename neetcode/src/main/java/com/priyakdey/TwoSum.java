package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TwoSum {

    // Given an array of integers nums and an integer target, return the indices i and j such that
    // nums[i] + nums[j] == target and i != j.
    // You may assume that every input has exactly one pair of indices i and j that satisfy
    // the condition.
    // Return the answer with the smaller index first.

    // Use a HashMap to store each number's index while iterating.
    // For each num, check if target - num (the complement) exists in the map.
    // If found, return the indices.
    // This ensures O(n) time lookup and guarantees the smaller index appears first.

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

        throw new IllegalArgumentException("invalid input");
    }

}
