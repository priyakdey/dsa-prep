package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class CloneGraph {

    // Given a node in a connected undirected graph, return a deep copy of the graph.
    // Each node in the graph contains an integer value and a list of its neighbors.

    // DFS with hashmap to clone each node; store original → clone mapping to avoid
    // revisits and handle cycles.
    // Use recursion to clone neighbors and build the deep copy.

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> mappings) {
        if (!mappings.containsKey(node)) {
            mappings.put(node, new Node(node.val));
        }

        Node cloneNode = mappings.get(node);

        for (Node neighbor : node.neighbors) {
            if (!mappings.containsKey(neighbor)) {
                mappings.put(neighbor, cloneGraph(neighbor, mappings));
            }

            Node cloneNeighbor = mappings.get(neighbor);
            cloneNode.neighbors.add(cloneNeighbor);
        }

        return cloneNode;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
