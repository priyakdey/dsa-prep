package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NumberOfOnesBits {

    // NOTE: Right-shift n and count how many bits are set using (n >> i) & 1.
    // Time: O(1), Space: O(1).

    public int hammingWeight(int n) {
        int setCount = 0;
        for (int i = 0; i < 32; i++) {
            setCount += ((n >> i) & 1);
        }

        return setCount;
    }

}
