package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CountingBits {

    // NOTES:
    // DP problem.
    // For power of 2 count = 1
    // For anything else, count = 1 + count at greatest smaller power of 2
    //
    // Time Complexity: O(n), Space Complexity: O(n)

    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        bitCounts[0] = 0;

        int prevPower = 1;
        int nextPower = 1;

        for (int i = 1; i <= n; i++) {
            if (i == nextPower) {
                bitCounts[i] = 1;
                prevPower = nextPower;
                nextPower = nextPower << 1;
            } else {
                bitCounts[i] = 1 + bitCounts[i - prevPower];
            }
        }

        return bitCounts;
    }

}
