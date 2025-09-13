package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class QuickSort {

    // NOTE: This implementation of QuickSort uses the Lomuto's partition scheme:
    // Pivot = last element (array[right])
    // pivotIndex tracks boundary of elements < pivot
    // After one scan, swaps pivot into its correct sorted position
    //
    // Time Complexity: Best / Average Case: O(n log n)
    // Worst Case: O(n²)
    // Space Complexity: O(log n)

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivotElement = array[right];

        int pivotIndex = left;
        int curr = left;

        while (curr <= right - 1) {
            if (array[curr] < pivotElement) {
                swap(array, pivotIndex, curr);
                pivotIndex++;
            }
            curr++;
        }

        array[right] = array[pivotIndex];
        array[pivotIndex] = pivotElement;
        return pivotIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
