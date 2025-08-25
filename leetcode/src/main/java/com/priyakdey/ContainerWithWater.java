package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ContainerWithWater {

    // NOTE: Two-pointer technique from both ends, greedily narrowing inward based on shorter
    // height to maximize area.
    // Time: O(n), Space: O(1).

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int boundingHeight = Math.min(height[left], height[right]);
            int area = boundingHeight * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
