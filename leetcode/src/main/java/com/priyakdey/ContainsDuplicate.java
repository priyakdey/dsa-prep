package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ContainsDuplicate {

    // NOTE: use a set to look back at visited values
    // O(n) amortized time complexity, while space is O(n)

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) return true;
            visited.add(num);
        }

        return false;
    }

}
