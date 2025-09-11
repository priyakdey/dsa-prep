package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BubbleSort {

    // NOTE: https://www.programiz.com/dsa/bubble-sort
    // Compare adjacent elements and swap if needed.
    //
    // Time complexity - O(n²) Space: O(1) — in-place sorting

    public static int[] bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

        return array;
    }

}
