package com.priyakdey.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class DepthFirstSearch {

    // NOTE: DFS → visit node, then recursively visit all its children (pre-order traversal).
    // addChild → creates and links a new child, returns parent for chaining.

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);

            for (Node child : this.children) {
                if (child != null) {
                    child.depthFirstSearch(array);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
