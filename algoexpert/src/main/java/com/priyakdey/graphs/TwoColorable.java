package com.priyakdey.graphs;

/**
 * @author Priyak Dey
 */
public class TwoColorable {

    public boolean twoColorable(int[][] edges) {
        int nodes = edges.length;
        int[] color = new int[nodes];
        for (int node = 0; node < nodes; node++) {
            if (color[node] == 0) {
                if (!visit(edges, node, -1, color)) return false;
            }
        }

        return true;
    }

    private boolean visit(int[][] edges, int currNode, int fromNode, int[] color) {
        if (color[currNode] == color[fromNode] || currNode == fromNode) return false;

        // mark node processing
        if (fromNode != -1) {
            color[currNode] = color[fromNode] ^ 1;
        }

        for (int edge: edges[currNode]) {
            if (!visit(edges, edge, currNode, color)) return false;
        }

        return true;
    }

}
