package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MergeSort {

    // NOTE: classic merge sort. Divide the array till 0/1 elements.
    // Then merge them back into the original array.

    public static int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, mid + 1, right);
    }

    private static void merge(int[] array, int leftArrFrom, int leftArrEnd,
                              int rightArrFrom, int rightArrEnd) {
        int leftLength = leftArrEnd - leftArrFrom + 1;
        int rightLength = rightArrEnd - rightArrFrom + 1;

        int length = leftLength + rightLength;

        int[] temp = new int[length];

        int i = leftArrFrom, j = rightArrFrom;
        int curr = 0;

        while (i <= leftArrEnd && j <= rightArrEnd) {
            if (array[i] <= array[j]) {
                temp[curr++] = array[i++];
            } else {
                temp[curr++] = array[j++];
            }
        }

        while (i <= leftArrEnd) {
            temp[curr++] = array[i++];
        }

        while (j <= rightArrEnd) {
            temp[curr++] = array[j++];
        }

        curr = 0;

        i = leftArrFrom;
        while (i <= leftArrEnd) {
            array[i++] = temp[curr++];
        }

        j = rightArrFrom;
        while (j <= rightArrEnd) {
            array[j++] = temp[curr++];
        }
    }

}
