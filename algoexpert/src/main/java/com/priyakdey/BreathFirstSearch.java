package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BreathFirstSearch {

    // NOTE: BFS → use a queue, visit nodes level by level (FIFO order).
    // addChild → link new child and return parent for chaining.

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Deque<Node> queue = new ArrayDeque<>();

            queue.offer(this);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);

                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
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
