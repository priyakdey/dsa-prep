package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

/**
 * @author Priyak Dey
 */
public class IterativeInorderTraversal {

    // NOTES:
    // Use an explicit stack instead of recursion
    // Push all left nodes until null
    // Pop → visit (callback) → move to right subtree
    // Repeat until stack empty
    //
    // Time: O(n) Space: O(h)

    public static void iterativeInOrderTraversal(BinaryTree tree,
                                                 Function<BinaryTree, Void> callback) {
        Deque<BinaryTree> stack = new ArrayDeque<>();
        BinaryTree curr = tree;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();
            callback.apply(curr);

            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
