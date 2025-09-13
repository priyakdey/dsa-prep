package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class SmallestDifference {

    // NOTES:
    // Sort both arrays
    // Use two pointers to scan through them
    // Track pair with minimum absolute difference
    // Move pointer of smaller element forward
    //
    // Time: O(n log n + m log m) Space: O(1)


    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int minDiff = Integer.MAX_VALUE;
        int x = arrayOne[0];
        int y = arrayTwo[0];

        int i = 0, j = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            int absDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (absDiff < minDiff) {
                minDiff = absDiff;
                x = arrayOne[i];
                y = arrayTwo[j];
            }

            if (arrayOne[i] <= arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return new int[]{x, y};
    }

}
