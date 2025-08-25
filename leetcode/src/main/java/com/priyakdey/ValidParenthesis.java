package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ValidParenthesis {

    // NOTE: Use a stack to match closing brackets with their corresponding opening ones using a map.
    // If mismatch or unbalanced, return false.
    // Time: O(n), Space: O(n).

    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
