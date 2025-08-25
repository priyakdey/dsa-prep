package com.priyakdey;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LongestConsecutiveSequence {

    // NOTE: Uses a HashSet for O(1) lookup/removal; for each number, expands left/right to count
    // consecutive streak, removing visited numbers to avoid redundant work.
    // Achieves O(n) time.

    public int longestConsecutive(int[] nums) {
        Objects.requireNonNull(nums);
        int length = nums.length;

        if (length < 2) return length;

        int maxStreak = 1;

        Set<Integer> toProcess = new HashSet<>();
        for (int num : nums) {
            toProcess.add(num);
        }

        for (int num : nums) {
            if (!toProcess.contains(num)) continue;

            int right = num;
            while (toProcess.contains(right)) {
                toProcess.remove(right);
                right++;
            }

            int left = num - 1;
            while (toProcess.contains(left)) {
                toProcess.remove(left);
                left--;
            }

            int streak = (right - 1) - (left + 1) + 1;
            maxStreak = Math.max(maxStreak, streak);
        }

        return maxStreak;
    }

}
