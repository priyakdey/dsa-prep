package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class TwoFurthestHousesWithDifferentColors {

    // NOTES:
    // Brute-force idea: fix left house, scan from rightmost backwards until different color found;
    // track max distance.
    //
    // Time: O(n²) worst-case (nested loops), but inner loop breaks early often

    public int maxDistance(int[] colors) {
        int length = colors.length;
        int maxDistance = 0;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (colors[i] != colors[j]) {
                    maxDistance = Math.max(maxDistance, j - i);
                    break;
                }
            }
        }

        return maxDistance;
    }

}

