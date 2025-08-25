package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LongestIncreasingSubsequence {

    // TODO: revist

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = nums.length;
        int[] subsequence = new int[length];
        subsequence[0] = nums[0];
        int cursor = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > subsequence[cursor - 1]) {
                subsequence[cursor++] = num;
            } else {
                int index = findIndexOfNextGreaterElements(subsequence, cursor, num);
                subsequence[index] = num;
                cursor = index + 1;
            }
        }

        return cursor;
    }


    private int findIndexOfNextGreaterElements(int[] arr, int cursor, int target) {
        int left = 0, right = cursor;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

}
