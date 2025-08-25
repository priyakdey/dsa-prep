package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MinCostClimbing {

    // You are given an array of integers cost where cost[i] is the cost of taking a step from the
    // ith floor of a staircase. After paying the cost, you can step to either the (i + 1)th floor
    // or the (i + 2)th floor.
    // You may choose to start at the index 0 or the index 1 floor.
    // Return the minimum cost to reach the top of the staircase, i.e. just past the
    // last index in cost.

    // Use bottom-up DP from the end:
    // dp[i] = cost[i] + min(dp[i+1], dp[i+2]).
    // Final answer is min(dp[0], dp[1]) since you can start from index 0 or 1.

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;

        if (length == 1) return cost[0];
        if (length == 2) return Math.min(cost[0], cost[1]);

        int[] minCost = new int[length];

        minCost[length - 1] = cost[length - 1];
        minCost[length - 2] = cost[length - 2];

        for (int i = length - 3; i >= 0; i--) {
            minCost[i] = cost[i] + Math.min(minCost[i + 1], minCost[i + 2]);
        }

        return Math.min(minCost[0], minCost[1]);
    }

}
