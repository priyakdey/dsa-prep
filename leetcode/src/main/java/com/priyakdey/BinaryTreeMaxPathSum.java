package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinaryTreeMaxPathSum {

    // NOTE: At each node, compute max path = max(node, node + l, node + r, node + l + r).
    // Track global max via reference. Return max path = max(node, node + l, node + r).
    // Time: O(n), Space: O(h) (stack).

    public int maxPathSum(TreeNode root) {
        int[] maxPathSumRef = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, maxPathSumRef);

        return maxPathSumRef[0];
    }

    private int maxPathSum(TreeNode node, int[] maxPathSumRef) {
        if (node.left == null && node.right == null) {
            maxPathSumRef[0] = max(maxPathSumRef[0], node.val);
            return node.val;
        }

        int leftMaxPathSum = 0, rightMaxPathSum = 0;

        if (node.left != null) {
            leftMaxPathSum = maxPathSum(node.left, maxPathSumRef);
        }
        if (node.right != null) {
            rightMaxPathSum = maxPathSum(node.right, maxPathSumRef);
        }

        int maxPathSumAtNode = max(node.val, node.val + leftMaxPathSum,
                node.val + rightMaxPathSum, node.val + leftMaxPathSum + rightMaxPathSum);
        maxPathSumRef[0] = max(maxPathSumRef[0], maxPathSumAtNode);

        return max(node.val, node.val + leftMaxPathSum, node.val + rightMaxPathSum);
    }

    private int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(value, max);
        }

        return max;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
