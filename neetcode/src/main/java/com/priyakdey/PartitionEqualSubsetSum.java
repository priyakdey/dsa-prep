package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class PartitionEqualSubsetSum {

    // You are given an array of positive integers nums.
    // Return true if you can partition the array into two subsets, subset1 and subset2 where
    // sum(subset1) == sum(subset2). Otherwise, return false.

    // Use top-down DP with memoization to determine if the array can be partitioned into
    // two subsets with equal sum.
    // If total sum is odd → return false.
    // At each index, either include or exclude the current number in the subset.

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        Boolean[][] cache = new Boolean[nums.length + 1][totalSum + 1];
        return canPartition(nums, 0, 0, totalSum, cache);
    }

    private boolean canPartition(int[] nums, int index, int leftSum, int totalSum,
                                 Boolean[][] cache) {
        if (index == nums.length) return false;
        if ((leftSum << 1) == totalSum) return true;

        if (cache[index][leftSum] != null) return cache[index][leftSum];

        boolean can = canPartition(nums, index + 1, leftSum, totalSum, cache) ||
                canPartition(nums, index + 1, leftSum + nums[index], totalSum, cache);
        cache[index][leftSum] = can;
        return can;
    }
}
