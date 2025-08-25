package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseBits {

    // NOTE: Extract each bit from n using (n >> i) & 1 and set it at position 31 - i in result.
    // Processes all 32 bits.
    // Time: O(1), Space: O(1).

    public int reverseBits(int n) {
        int reverse = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            reverse = reverse | bit << (31 - i);
        }

        return reverse;
    }

}
