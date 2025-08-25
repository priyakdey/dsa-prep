package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseBits {

    // Given a 32-bit unsigned integer n, reverse the bits of the binary representation of n and
    // return the result.

    // Iterate over all 32 bits.
    // For each bit, shift it to its reversed position and accumulate in the result.
    // Use unsigned right shift (>>>) to handle sign bits correctly.

    public int reverseBits(int n) {
        long reverse = 0;

        for (int i = 0; i < 32; i++) {
            reverse = reverse | ((long) (n & 1) << (31 - i));
            n = n >>> 1;
        }

        return (int) reverse;
    }

}
