package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CollidingAsteroids {

    // NOTE: Use a stack to simulate asteroid collisions:
    // Push right-moving asteroids (> 0).
    // On left-moving asteroid (< 0), check for collisions with top of stack.
    // If left > 0 && right < 0, resolve collision by comparing magnitudes.
    // Continue popping if collision continues; push survivor if any.
    //
    // Time: O(n), Space: O(n) — single pass with backtracking via stack

    public int[] collidingAsteroids(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(asteroids.length);

        for (int asteroid : asteroids) {
            if (asteroid == 0) continue;

            stack.push(asteroid);

            while (stack.size() > 1) {
                int right = stack.pop();
                int left = stack.pop();
                if (left > 0 && right < 0) {
                    int weight = left + right;
                    if (weight > 0) {
                        stack.push(left);
                    } else if (weight < 0) {
                        stack.push(right);
                    } else {
                        break;
                    }
                } else {
                    stack.push(left);
                    stack.push(right);
                    break;
                }
            }

        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}
