package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class LargestRectangleUnderSkyline {

    // NOTE: Largest Rectangle Under Skyline (Monotonic Stack):
    // For each building, find:
    // Left bound: first shorter bar on the left
    // Right bound: first shorter bar on the right
    // Use two monotonic stacks (one left-to-right, one right-to-left) to compute bounds in O(n)
    // Compute area: height × (right - left + 1) for each building
    //
    // Time: O(n), Space: O(n)

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        int length = buildings.size();
        Deque<Building> stack = new ArrayDeque<>(length);

        int[] rightBoundIndex = new int[length];
        Arrays.fill(rightBoundIndex, length - 1);

        int[] leftBoundIndex = new int[length];
        Arrays.fill(leftBoundIndex, 0);


        // find right bound index
        for (int i = 0; i < length; i++) {
            int building = buildings.get(i);
            while (!stack.isEmpty() && building < stack.peek().building) {
                rightBoundIndex[stack.pop().index] = i - 1;
            }

            stack.push(new Building(building, i));
        }

        stack.clear();

        // find left bound index
        for (int i = length - 1; i >= 0; i--) {
            int building = buildings.get(i);
            while (!stack.isEmpty() && building < stack.peek().building) {
                leftBoundIndex[stack.pop().index] = i + 1;
            }

            stack.push(new Building(building, i));
        }

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            int building = buildings.get(i);
            int area = (rightBoundIndex[i] - leftBoundIndex[i] + 1) * building;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private record Building(int building, int index) {
    }


}
