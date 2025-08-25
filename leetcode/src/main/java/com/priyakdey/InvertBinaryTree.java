package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    // NOTE: Use post-order recursion: swap left/right after inverting subtrees.
    // Time: O(n), Space: O(h) (stack). Simple and elegant tree flip. ✅

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public class TreeNode {
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
