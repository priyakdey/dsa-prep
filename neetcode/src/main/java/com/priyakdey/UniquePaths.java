package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class UniquePaths {

    // There is an m x n grid where you are allowed to move either down or to the right at
    // any point in time.
    // Given the two integers m and n, return the number of possible unique paths that can be
    // taken from the top-left corner of the grid (grid[0][0]) to the
    // bottom-right corner (grid[m - 1][n - 1]).
    // You may assume the output will fit in a 32-bit integer.

    // Use bottom-up DP with space optimization to count unique paths from top-left to bottom-right.
    // Only right and down moves are allowed, so:
    // dp[row][col] = dp[row + 1][col] + dp[row][col + 1]
    // Use two 1D arrays: prev (next row) and curr (current row) to compute path counts.

    public int uniquePaths(int m, int n) {
        if (m == 1) return 1;

        int[] prev = new int[n];
        int[] curr = new int[n];

        Arrays.fill(prev, 1);

        for (int row = m - 2; row >= 0; row--) {
            curr[n - 1] = 1;
            for (int col = n - 2; col >= 0; col--) {
                curr[col] = curr[col + 1] + prev[col];
            }

            System.arraycopy(curr, 0, prev, 0, n);
        }

        return prev[0];
    }

}
