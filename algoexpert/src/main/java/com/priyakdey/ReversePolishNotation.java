package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ReversePolishNotation {

    // NOTE: Reverse Polish Notation (Postfix Expression Evaluation):
    // Use a stack to evaluate postfix expressions:
    // Push operands
    // On operator, pop two operands, apply op, push result
    // Handles + - * / with left-right operand order
    //
    // Time: O(n), Space: O(n)

    public int reversePolishNotation(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>(tokens.length);

        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (operators.contains(token)) {
                int rightOperand = stack.pop();
                int leftOperand  = stack.pop();
                int result = switch (token) {
                    case "+" -> leftOperand + rightOperand;
                    case "-" -> leftOperand - rightOperand;
                    case "*" -> leftOperand * rightOperand;     // can overflow
                    case "/" -> leftOperand / rightOperand;     // can divide by zero
                    default -> throw new IllegalArgumentException("invalid operator");
                };
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return Objects.requireNonNull(stack.peek());
    }

}
