package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class SunsetViews {

    // NOTE: Sunset Views (Monotonic Stack Approach):
    // For each building, determine if it's taller than all buildings between it
    // and the direction of the sun
    // Use a monotonic decreasing stack to find buildings with no taller building blocking
    // view in the sun's direction.
    // Maintain greaterHeight[] to mark blocked buildings.
    // Buildings with -1 in nextGreaterHeight have a clear view
    //
    // Time: O(n), Space: O(n)

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        return switch (direction) {
            case "EAST" -> sunsetViewsEast(buildings);
            case "WEST" -> sunsetViewsWest(buildings);
            default -> throw new IllegalArgumentException("invalid direction");
        };
    }

    private ArrayList<Integer> sunsetViewsEast(int[] buildings) {
        int length = buildings.length;
        Deque<Building> stack = new ArrayDeque<>(length);
        int[] greaterHeightInEast = new int[length];
        Arrays.fill(greaterHeightInEast, -1);

        for (int i = 0; i < length; i++) {
            int height = buildings[i];
            while (!stack.isEmpty() && height >= stack.peek().height) {
                Building building = stack.pop();
                greaterHeightInEast[building.index] = i;
            }
            stack.push(new Building(height, i));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (greaterHeightInEast[i] == -1) {
                list.add(i);
            }
        }

        return list;
    }

    private ArrayList<Integer> sunsetViewsWest(int[] buildings) {
        int length = buildings.length;
        Deque<Building> stack = new ArrayDeque<>(length);
        int[] greaterHeightInWest = new int[length];
        Arrays.fill(greaterHeightInWest, -1);

        for (int i = length - 1; i >= 0; i--) {
            int height = buildings[i];
            while (!stack.isEmpty() && height >= stack.peek().height) {
                Building building = stack.pop();
                greaterHeightInWest[building.index] = i;
            }
            stack.push(new Building(height, i));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (greaterHeightInWest[i] == -1) {
                list.add(i);
            }
        }

        return list;
    }

    private record Building(int height, int index) {
    }

}
