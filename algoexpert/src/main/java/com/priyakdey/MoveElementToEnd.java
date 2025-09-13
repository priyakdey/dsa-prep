package com.priyakdey;

import java.util.Collections;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class MoveElementToEnd {

    // NOTES:
    // Move Element To End (Two-Pointer Swap):
    // Maintain left and right pointers
    // If left is toMove, swap with right (if not toMove) and shrink window
    // Otherwise advance left
    // Repeat until pointers cross
    //
    // Time: O(n), Space: O(1)

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0, right = array.size() - 1;

        while (left < right) {
            if (array.get(left) == toMove && array.get(right) == toMove) {
                right--;
            } else if (array.get(left) == toMove && array.get(right) != toMove) {
                Collections.swap(array, left, right);
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) == toMove) {
                left++;
                right--;
            } else if (array.get(left) != toMove && array.get(right) != toMove) {
                left++;
            }
        }

        return array;
    }

}
