package com.priyakdey.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class YoungestCommonAncestor {

    // NOTE: Youngest Common Ancestor → build ancestor chains, trim longer path,
    // then move up together until first common node.

    // TODO: This can be done using binary lifting. Check the algorithm and implement.

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        if (descendantOne == topAncestor || descendantTwo == topAncestor) {
            return topAncestor;
        }

        Deque<AncestralTree> ancestorsOne = getAncestors(descendantOne);
        Deque<AncestralTree> ancestorsTwo = getAncestors(descendantTwo);

        while (!ancestorsOne.isEmpty() && !ancestorsTwo.isEmpty()
                && ancestorsOne.peekFirst() != ancestorsTwo.peekFirst()) {
            if (ancestorsOne.size() > ancestorsTwo.size()) {
                ancestorsOne.pollFirst();
            } else if (ancestorsOne.size() < ancestorsTwo.size()) {
                ancestorsTwo.pollFirst();
            } else {
                ancestorsOne.pollFirst();
                ancestorsTwo.pollFirst();
            }
        }

        if (ancestorsOne.isEmpty()) {
            throw new IllegalArgumentException("invalid input");        // unreachable for problem constraints
        }

        return ancestorsOne.pollFirst();
    }

    private static Deque<AncestralTree> getAncestors(AncestralTree node) {
        Deque<AncestralTree> ancestors = new ArrayDeque<>();

        while (node != null) {
            ancestors.offerLast(node);
            node = node.ancestor;
        }

        return ancestors;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
