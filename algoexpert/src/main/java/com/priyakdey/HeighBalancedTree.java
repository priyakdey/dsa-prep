package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HeighBalancedTree {

    // NOTE:
    // Use recursive helper checkHeight:
    // Returns subtree height if balanced, else returns -1
    //
    // Time: O(n) Space: O(h)

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return checkHeight(tree) != -1;
    }

    private int checkHeight(BinaryTree node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;


        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
