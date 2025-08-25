package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class IslandAndTreasures {

    // You are given a m×n 2D grid initialized with these three possible values:
    //      -1 - A water cell that can not be traversed.
    //       0 - A treasure chest.
    //         INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
    //
    // Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot
    // reach a treasure chest then the value should remain INF.
    // Assume the grid can only be traversed up, down, left, or right. Modify the grid in-place.

    // Use multi-source BFS from all treasure cells (value 0) to fill shortest distances to
    // reachable land (INF), skipping water (-1). Queue holds cells with their current distance.
    // Modify grid in-place.


    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new Cell(row, col, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            grid[cell.row][cell.col] = Math.min(grid[cell.row][cell.col], cell.distance);

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);
                if (nextCell.inRange(rows, cols) &&
                        grid[nextCell.row][nextCell.col] == Integer.MAX_VALUE) {
                    queue.offer(nextCell);
                }
            }
        }
    }

    private record Cell(int row, int col, int distance) {

        Cell nextCell(int[] direction) {
            return new Cell(row + direction[0], col + direction[1], distance + 1);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

    }

}
