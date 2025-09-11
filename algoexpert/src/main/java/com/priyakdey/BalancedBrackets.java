package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class BalancedBrackets {

    // NOTE: Balanced Brackets (Stack + Map):
    // Use a stack to track opening brackets.
    // On encountering closing, check if top matches via Map<closing, opening>
    // Skip non-bracket characters using a Set.
    //
    // Time: O(n), Space: O(n)

    public static boolean balancedBrackets(String str) {
        Set<Character> brackets = Set.of(')', '(', '}', '{', ']', '[');
        Map<Character, Character> bracketMap = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>(str.length());

        for (char ch : str.toCharArray()) {
            if (!brackets.contains(ch)) continue;

            if (bracketMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracketMap.get(ch)) return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
