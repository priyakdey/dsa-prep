package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SingleNumber {

    //You are given a non-empty array of integers nums. Every integer appears twice except for one.
    // Return the integer that appears only once.
    //
    // You must implement a solution with O(n) runtime complexity and use only O(1) extra space.


    // use the properties of xor:
    // (a ^ b) ^ c = a ^ (b ^ c)
    // a ^ a = 0
    // a ^ 0 = a

    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;
    }

}
