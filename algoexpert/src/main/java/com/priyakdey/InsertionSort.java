package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InsertionSort {

    // NOTE: https://www.programiz.com/dsa/insertion-sort
    // Insertion Sort (with Binary Search Optimization):
    // Iterate through array, inserting each element into its correct position among the
    // already-sorted prefix.
    // Uses binary search (findInsertIndex) to find insertion point → reduces comparisons but
    // still shifts elements.
    //
     // Time complexity: O(n²), Space complexity: O(1)

    public static int[] insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int key = array[i];
            int index = findInsertIndex(array, i, key);
            if (index == -1) continue;

            for (int j = i; j > index; j--) {
                array[j] = array[j - 1];
            }

            array[index] = key;
        }

        return array;
    }

    /**
     * Finds the insertion position of the key in the array from 0 to end,
     * where end is exclusive.
     *
     * @param array int[]
     * @param end   int
     * @param key   int
     * @return insertion index of key in the array[0:end]
     */
    private static int findInsertIndex(int[] array, int end, int key) {
        int left = 0, right = end - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key <= array[mid]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
