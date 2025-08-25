package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaximumProductSubarray {

    // Given an integer array nums, find a subarray that has the largest product within the array
    // and return it.
    // A subarray is a contiguous non-empty sequence of elements within an array.
    // You can assume the output will fit into a 32-bit integer.

    // Track both maxTill and minTill to handle negative flips.
    // For each element, update both using max/min of (num, num * maxTill, num * minTill).
    // Avoid special-casing 0 — let the math reset naturally.

    public int maxProduct(int[] nums) {
        // constraint: 1 <= nums.length <= 1000
        int maxProduct = nums[0];
        int maxTill = nums[0];
        int minTill = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxTill = 0;
                minTill = 0;
            } else {
                int tempMax = max(maxTill * nums[i], minTill * nums[i], nums[i]);
                int tempMin = min(maxTill * nums[i], minTill * nums[i], nums[i]);
                maxTill = tempMax;
                minTill = tempMin;
            }

            maxProduct = Math.max(maxProduct, maxTill);
        }

        return maxProduct;
    }

    private int max(int... values) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : values) {
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }

    private int min(int... values) {
        int minvalue = Integer.MAX_VALUE;
        for (int value : values) {
            minvalue = Math.min(minvalue, value);
        }

        return minvalue;
    }

}
