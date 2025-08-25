package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HammingWeight {

    // You are given an unsigned integer n. Return the number of 1 bits in its binary representation

    // Unsigned right shifts 32 times and find the bit

    public int hammingWeight(int n) {
        int setBits = 0;

        for (int i = 0; i < 32; i++) {
            setBits += (n & 1);
            n = n >>> 1;
        }

        return setBits;
    }

}
