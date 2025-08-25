package com.priyakdey.graphs;

/**
 * @author Priyak Dey
 */
public class SingleCycleCheck {

    // NOTE: Single Cycle Check → jump through array indices, mark visited, and ensure you
    // return to start after exactly n steps.

    public static boolean hasSingleCycle(int[] array) {
        int length = array.length;

        if (length <= 1) return true;

        int startIndex = 0;
        int currIndex = mod(startIndex + array[startIndex], length);

        int visited = 1;
        array[startIndex] = 0;      // mutate the original array

        while (currIndex != startIndex) {
            if (array[currIndex] == 0) return false;

            int nextIndex = mod(currIndex + array[currIndex], length);
            array[currIndex] = 0;
            currIndex = nextIndex;
            visited++;
        }

        return visited == length;
    }

    private static int mod(int x, int y) {
        return ((x % y) + y) % y;
    }

}
