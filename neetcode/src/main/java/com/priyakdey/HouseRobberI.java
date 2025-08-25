package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HouseRobberI {

    // You are given an integer array nums where nums[i] represents the amount of money the
    // ith house has. The houses are arranged in a straight line, i.e. the ith house is the
    // neighbor of the (i-1)th and (i+1)th house.
    // You are planning to rob money from the houses, but you cannot rob two adjacent houses
    // because the security system will automatically alert the police if two adjacent
    // houses were both broken into.
    // Return the maximum amount of money you can rob without alerting the police.

    // Use space-optimized bottom-up DP:
    // Track next1 (loot from i+1) and next2 (loot from i+2).
    // At i: nums[i] + next2.
    // Shift window after each step.

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int nextMaxLoot = nums[length - 1];
        int immNextLoot = nums[length - 2];


        for (int i = length - 3; i >= 0; i--) {
            int curr_max_loot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, immNextLoot);
            immNextLoot = curr_max_loot;
        }

        return Math.max(nextMaxLoot, immNextLoot);
    }

}
