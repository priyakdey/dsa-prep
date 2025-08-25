package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestIncreasingSubsequence {

    // Given an integer array nums, return the length of the longest strictly increasing subsequence.

    // Use top-down DP with memoization to find the longest increasing subsequence.
    // At each index, choose to:
    //      Skip the current element
    //      Include it if it's greater than the previous element in the subsequence
    //
    // Track index and prevIndex to guide recursion.
    // Memoize results in cache[index][prevIndex].

    public int lengthOfLIS(int[] nums) {
        Integer[][] cache = new Integer[nums.length+1][nums.length+1];
        return lengthOfLIS(nums, 0,-1, cache);
    }

    private int lengthOfLIS(int[] nums, int index, int prevIndex, Integer[][] cache) {
        if (index == nums.length) return 0;

        if (prevIndex != -1 && cache[index][prevIndex] != null) return cache[index][prevIndex];

        int maxLength = lengthOfLIS(nums, index + 1, prevIndex, cache);

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            maxLength = Math.max(maxLength, 1 + lengthOfLIS(nums, index + 1, index, cache));
        }

        if (prevIndex != -1) cache[index][prevIndex] = maxLength;
        return maxLength;
    }
}
