package com.priyakdey;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class LargestRange {

    public static int[] largestRange(int[] array) {
        Set<Integer> notVisited = new HashSet<>(array.length);
        for (int num : array) {
            notVisited.add(num);
        }

        int maxRange = 0;
        int x = 1, y = -1;

        for (int num : array) {
            if (!notVisited.contains(num)) continue;

            int left = num;
            while (notVisited.contains(left)) {
                notVisited.remove(left);
                left--;
            }

            int right = num + 1;
            while (notVisited.contains(right)) {
                notVisited.remove(right);
                right++;
            }

            int range = (right - 1) - (left + 1) + 1;
            if (range > maxRange) {
                maxRange = range;
                x = left + 1;
                y = right - 1;
            }
        }

        return new int[]{x, y};
    }

}
