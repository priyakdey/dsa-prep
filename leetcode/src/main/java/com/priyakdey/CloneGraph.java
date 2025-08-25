package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class CloneGraph {

    // NOTE: Use DFS with a Map<Node, Node> to memoize cloned nodes and avoid cycles.
    // Recursively clone each neighbor.
    // Time: O(V + E).

    public Node cloneGraph(Node node) {
        return cloneNode(node, new HashMap<>());
    }

    private Node cloneNode(Node node, Map<Node, Node> map) {
        if (node == null) return null;

        Node _node = new Node(node.val);
        map.put(node, _node);

        for (Node nbor : node.neighbors) {
            Node _nbor = map.get(nbor);
            if (_nbor == null) {
                _nbor = cloneNode(nbor, map);
            }
            _node.neighbors.add(_nbor);
        }

        return _node;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
