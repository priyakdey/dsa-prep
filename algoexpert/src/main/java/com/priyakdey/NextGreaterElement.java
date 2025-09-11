package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class NextGreaterElement {

    // NOTE: Next Greater Element (Circular Array, Monotonic Stack):
    // Simulate circular array by looping twice over input
    // Use monotonic decreasing stack to store (value, index)
    // On each pass, pop from stack when current value > top.value, and update result[top.index]
    // Fill unresolvable entries with -1
    //
    // Time: O(n), Space: O(n)

    public int[] nextGreaterElement(int[] array) {
        int length = array.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Deque<Pair> stack = new ArrayDeque<>();

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < length; i++) {
                int value = array[i];
                while (!stack.isEmpty() && value > stack.peek().value) {
                    result[stack.pop().index] = value;
                }

                stack.push(new Pair(value, i));
            }
        }

        return result;
    }

    private record Pair(int value, int index) {
    }

}
