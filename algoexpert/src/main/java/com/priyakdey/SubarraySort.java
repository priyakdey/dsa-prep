package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SubarraySort {

    public static int[] subarraySort(int[] array) {
        int length = array.length;
        if (length == 1) return new int[]{-1, -1};

        int leftIndex = -1, rightIndex = -1;

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                rightIndex = i;
            }
        }

        int min = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                leftIndex = i;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

}
