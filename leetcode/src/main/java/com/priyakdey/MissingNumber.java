package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MissingNumber {

    // Use arithmetic formula: sum of 0..n is n(n+1)/2.
    // Subtract actual sum to find the missing number.
    // Time: O(n), Space: O(1).

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int length = nums.length;
        int expectedSum = length * (length + 1) / 2;

        return expectedSum - sum;
    }

}
