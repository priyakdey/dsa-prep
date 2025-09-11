package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinMaxStack {

    // NOTE: MinMax Stack (Augmented Stack Design):
    // Store each element as a Tuple(value, minSoFar, maxSoFar).
    // push() tracks current min/max with each new entry.
    // peek(), getMin(), and getMax() all run in O(1) time.
    // Eliminates need for scanning the stack
    //
    // Time: O(1) for all operations, Space: O(n)

    private final Deque<Tuple> stack;

    public MinMaxStack() {
        stack = new ArrayDeque<>();
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stack.peek().value;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stack.pop().value;
    }

    public void push(Integer number) {
        Tuple tuple;
        if (stack.isEmpty()) {
            tuple = new Tuple(number, number, number);
        } else {
            tuple = new Tuple(number, Math.min(number, getMin()), Math.max(number, getMax()));
        }

        stack.push(tuple);
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stack.peek().min;
    }

    public int getMax() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return stack.peek().max;
    }

    private record Tuple(int value, int min, int max) {
    }

}
