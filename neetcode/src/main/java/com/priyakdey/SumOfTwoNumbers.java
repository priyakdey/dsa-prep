package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SumOfTwoNumbers {

    // Given two integers a and b, return the sum of the two integers without using
    // the + and - operators.

    // Use bitwise XOR (^) to add numbers without carrying.
    // Use bitwise AND (&) and left shift (<< 1) to compute the carry.
    // Repeat until carry is zero.

    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

}
