package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BranchSums {

    // NOTE:
    // Branch Sums (Binary Tree):
    // Perform DFS from root → leaf, accumulating path sums.
    // When a leaf is reached, add currSum to result list.
    // Uses recursion to traverse both left and right subtrees.
    //
    // Time: O(n) Space: O(h)

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        branchSums(root, 0, sums);
        return sums;
    }

    private static void branchSums(BinaryTree node, int currSum, List<Integer> sums) {
        if (node == null) return;

        currSum += node.value;

        if (node.left == null && node.right == null) {
            sums.add(currSum);
            return;
        }

        branchSums(node.left, currSum, sums);
        branchSums(node.right, currSum, sums);
    }
}
