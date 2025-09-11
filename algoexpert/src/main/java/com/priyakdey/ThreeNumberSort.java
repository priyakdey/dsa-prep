package com.priyakdey;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Priyak Dey
 */
public class ThreeNumberSort {

    // NOTE:
    // Use three pointers:
    // - left → boundary for order[0]
    // - right → boundary for order[2]
    // - curr → current index being processed
    // Swap accordingly:
    // - If order[0]: swap with left, move both
    // - If order[1]: just move curr
    // - If order[2]: swap with right, shrink boundary
    //
    // Time: O(n), Space: O(1)

    /**
     * This function sorts elements of array, in accordance the elements
     * given in the order array and use the Dutch Flag Algorithm Variant.
     *
     * @param array int[]
     * @param order int[]
     * @return sorted array
     */
    public int[] threeNumberSort(int[] array, int[] order) {
        int length = array.length;
        int left = 0, right = length - 1, curr = 0;

        while (curr <= right) {
            int value = array[curr];

            if (value == order[0]) {
                swap(array, curr, left);
                curr++;
                left++;
            } else if (value == order[1]) {
                curr++;
            } else {
                swap(array, curr, right);
                right--;
            }
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * This function sorts elements of array, in accordance the elements
     * given in the order array. This algorithm does a count of the elements
     * and overwrites the elements in the main array
     *
     * @param array int[]
     * @param order int[]
     * @return sorted array
     */
    public int[] threeNumberSortbyCount(int[] array, int[] order) {
        int a = 0, b = 0, c = 0;

        Arrays.sort();

        Collections.sort();

        for (int num : array) {
            if (num == order[0]) a++;
            else if (num == order[1]) b++;
            else c++;
        }

        int cursor = 0;
        while (a > 0) {
            array[cursor++] = order[0];
            a--;
        }

        while (b > 0) {
            array[cursor++] = order[1];
            b--;
        }

        while (c > 0) {
            array[cursor++] = order[2];
            c--;
        }

        return array;
    }

}
