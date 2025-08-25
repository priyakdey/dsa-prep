package com.priyakdey;

import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class HouseRobberII {

    // NOTES: Can't rob first and last together. So:
    // Rob from [0..n-2] and from [1..n-1]
    // Use DP from end → loot[i] = nums[i] + max(loot[i+2], loot[i+3]...)
    // Optimized with rolling variables (nextLoot, nextMaxLoot)
    //
    // Time: O(n), Space: O(1).

    public int rob(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;
        if (length == 0) throw new IllegalArgumentException("invalid argument");

        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int maxRob1 = rob(nums, length - 4, 0, length - 2, length - 3);
        int maxRob2 = rob(nums, length - 3, 1, length - 1, length - 2);

        return Math.max(maxRob1, maxRob2);
    }

    private int rob(int[] nums, int from, int end, int lastLootIdx, int secondLastLootIdx) {
        int nextMaxLoot = nums[lastLootIdx];
        int nextLoot = nums[secondLastLootIdx];

        for (int i = from; i >= end; i--) {
            int currLoot = nums[i] + nextMaxLoot;
            nextMaxLoot = Math.max(nextMaxLoot, nextLoot);
            nextLoot = currLoot;
        }

        return Math.max(nextLoot, nextMaxLoot);
    }

}
