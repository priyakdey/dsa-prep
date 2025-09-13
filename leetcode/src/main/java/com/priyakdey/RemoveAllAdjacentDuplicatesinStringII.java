package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class RemoveAllAdjacentDuplicatesinStringII {

    // NOTES:
    // Use a stack storing (char, freq)
    // Increment frequency if top matches current char
    // Pop when freq reaches k
    // Reconstruct final string by repeating each char freq times
    //
    // Time: O(n), Space: O(n)


    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                stack.peek().freq += 1;
            } else {
                stack.push(new Pair(ch, 1));
            }

            if (Objects.requireNonNull(stack.peek()).freq == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            sb.repeat(pair.ch, pair.freq);
        }

        return sb.reverse().toString();
    }

    private static class Pair {
        private final char ch;
        private int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

    }

}
