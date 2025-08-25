package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SumOfTwoNumbers {

    // NOTE: Simulate 32-bit addition using bit-level logic:
    //
    // Use halfAdder = a ^ b, carry = a & b
    //
    // Build full adder from two half adders + OR on carries
    //
    // Assemble result bit by bit using sum |= (sumBit << i)
    // Avoids mem allocation and GC-safe, works for all signed ints.
    // Time: O(32), Space: O(1).

    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int sum = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            int result = fullAdder(x, y, carry);
            int sumBit = result & 1;
            carry = (result >> 1) & 1;
            sum = sum | (sumBit << i);
        }

        return sum;
    }

    private int fullAdder(int a, int b, int c) {
        int r1 = halfAdder(a, b);
        int s1 = r1 & 1;
        int c1 = (r1 >> 1) & 1;

        int r2 = halfAdder(s1, c);
        int sum = r2 & 1;

        int c2 = (r2 >> 1) & 1;
        int carry = c1 | c2;

        sum = sum | (carry << 1);
        return sum;
    }

    private int halfAdder(int a, int b) {
        int sum = a ^ b;
        int carry = a | b;
        sum = sum | (carry << 1);
        return sum;
    }

    private int[] sum(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) return new int[]{0, 0};
        if (a == 0 && b == 1 && c == 0) return new int[]{1, 0};
        if (a == 1 && b == 0 && c == 0) return new int[]{1, 0};
        if (a == 1 && b == 1 && c == 0) return new int[]{0, 1};
        if (a == 0 && b == 0 && c == 1) return new int[]{1, 0};
        if (a == 0 && b == 1 && c == 1) return new int[]{0, 1};
        if (a == 1 && b == 0 && c == 1) return new int[]{0, 1};
        if (a == 1 && b == 1 && c == 1) return new int[]{1, 1};

        throw new IllegalArgumentException("invalid input");
    }

}
