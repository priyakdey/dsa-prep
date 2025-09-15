package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaximumSubarray {

    // NOTES:
    // Kadane's algorithm

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);
        }

        return maxSum;
    }

}
