package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MonotonicArray {

    // NOTES:
    // Track two flags: isNonIncreasing and isNonDecreasing
    // Traverse once:
    // If array[i] < array[i-1] → not non-decreasing
    // If array[i] > array[i-1] → not non-increasing
    // Return true if at least one flag holds
    //
    // Time: O(n), Space: O(1)

    public static boolean isMonotonic(int[] array) {
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) isNonIncreasing = false;
            if (array[i] > array[i - 1]) isNonDecreasing = false;
        }

        return isNonIncreasing || isNonDecreasing;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(arr));
    }

}
