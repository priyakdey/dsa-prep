package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CountingBits {

    // Given an integer n, count the number of 1's in the binary representation of every number in
    // the range [0, n].
    // Return an array output where output[i] is the number of 1's in the binary
    // representation of i.

    // Use dynamic programming.
    // For each number, relate its bit count to a previously computed value.
    // If i is a power of 2, its bit count is 1.
    // Otherwise, bitCount[i] = 1 + bitCount[i - prevPower], where prevPower is the largest
    // power of 2 less than or equal to i.

    public int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        bitCount[0] = 0;
        if (n == 0) return bitCount;

        bitCount[1] = 1;
        if (n == 1) return bitCount;

        bitCount[2] = 1;
        if (n == 2) return bitCount;


        int prevPower = 2;
        int nextPower = 4;

        for (int i = 3; i <= n; i++) {
            if (i == nextPower) {
                bitCount[i] = 1;
                prevPower = nextPower;
                nextPower = nextPower << 1;
            } else {
                bitCount[i] = 1 + bitCount[i - prevPower];
            }
        }

        return bitCount;
    }

}
