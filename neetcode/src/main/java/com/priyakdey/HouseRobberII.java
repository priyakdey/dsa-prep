package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HouseRobberII {

    // You are given an integer array nums where nums[i] represents the amount of money the
    // ith house has. The houses are arranged in a circle, i.e. the first house and the
    // last house are neighbors.
    // You are planning to rob money from the houses, but you cannot rob two adjacent houses
    // because the security system will automatically alert the police if two adjacent
    // houses were both broken into.
    // Return the maximum amount of money you can rob without alerting the police.

    // In circular cases, split into two scenarios:
    // Rob 0 to n-2 (exclude last)
    // Rob 1 to n-1 (exclude first)
    // Use space-optimized DP for both, and return the maximum.

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        // start: loot the last house considering array to be flat
        int nextMaxLoot = nums[length - 1];
        int immNextLoot = nums[length - 2];

        for (int i = length - 3; i >= 1; i--) {
            int curr_max_loot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, immNextLoot);
            immNextLoot = curr_max_loot;
        }

        int maxLoot = Math.max(nextMaxLoot, immNextLoot);
        // end: loot the last house considering array to be flat

        // start: loot the second last house considering array to be flat
        nextMaxLoot = nums[length - 2];
        immNextLoot = nums[length - 3];

        for (int i = length - 4; i >= 0; i--) {
            int curr_max_loot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, immNextLoot);
            immNextLoot = curr_max_loot;
        }

        // end: loot the second last house considering array to be flat

        return Math.max(maxLoot, Math.max(nextMaxLoot, immNextLoot));
    }

}
