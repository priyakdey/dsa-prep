package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MissingNumber {

    // Given an array nums containing n integers in the range [0, n] without any duplicates,
    // return the single number in the range that is missing from nums.

    // Calculates the sum of numbers from 0 to n.
    // Subtracts the sum of the array to find the missing number.
    // Time complexity: O(n), space complexity: O(1).

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

}
