package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TargetSum {

    // You are given an array of integers nums and an integer target.
    // For each number in the array, you can choose to either add or subtract it to a total sum.
    // For example, if nums = [1, 2], one possible sum would be "+1-2=-1".
    // If nums=[1,1], there are two different ways to sum the input numbers to get a
    // sum of 0: "+1-1" and "-1+1".
    //
    // Return the number of different ways that you can build the expression such that the
    // total sum equals target.

    // Use DFS recursion to try adding and subtracting each number at every index.
    // Base case: if index == nums.length, return 1 if target == 0, else 0.
    // This explores all 2^n possible sign combinations.
    // To optimize, memoize subproblems using (index, target) as key.

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, 0,target);
    }

    private int findTargetSumWays(int[] nums, int index, int target) {
        if (index == nums.length) return target == 0 ? 1 : 0;

        return findTargetSumWays(nums, index + 1, target + nums[index]) +
                findTargetSumWays(nums, index + 1, target - nums[index]);
    }

}
