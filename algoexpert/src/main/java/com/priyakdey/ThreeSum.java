package com.priyakdey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ThreeSum {

    // NOTES:
    // Sort array first
    // Fix one number, then use two pointers (j, k) to find pairs that sum to targetSum - array[i]
    // Move pointers inward based on sum comparison
    // Collect valid triplets
    //
    // Time: O(n²) (outer loop × two-pointer scan)
    // Space: O(1) (ignoring output list)

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        int length = array.length;
        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int j = i + 1, k = length - 1;

            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[j], array[k]});
                    j++;
                    k--;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplets;
    }

}
