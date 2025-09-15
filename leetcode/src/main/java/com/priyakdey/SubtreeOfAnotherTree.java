package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class SubtreeOfAnotherTree {

    // NOTES:
    // Traverse root.
    // At each node, if values match, call isSubtreeInternal → recursively check
    // full structural + value equality.
    // If not equal, recurse left and right.

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (isSubtreeInternal(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSubtreeInternal(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return node1.val == node2.val
                && isSubtreeInternal(node1.left, node2.left)
                && isSubtreeInternal(node1.right, node2.right);
    }

    private static class TreeNode {
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
