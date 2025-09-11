package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SelectionSort {

    // NOTE: https://www.programiz.com/dsa/selection-sort
    // For each position i, find the minimum element in the unsorted part (i..n-1).
    // Swap it with element at i.
    // Repeats until array is sorted.
    //
    // Time complexity: O(n²), space complexity: O(1)

    public static int[] selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            array[index] = array[i];
            array[i] = min;
        }

        return array;
    }

}
