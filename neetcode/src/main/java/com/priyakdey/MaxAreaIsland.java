package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MaxAreaIsland {

    // You are given a matrix grid where grid[i] is either a 0 (representing water) or
    // 1 (representing land).
    // An island is defined as a group of 1's connected horizontally or vertically.
    // You may assume all four edges of the grid are surrounded by water.
    // The area of an island is defined as the number of cells within the island.
    // Return the maximum area of an island in grid. If no island exists, return 0.

    // Similar to Finding number of islands. Instead of component count, we count each cell
    // we visit in the DFS/BFS.

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        Deque<Cell> stack = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 1) continue;

                int area = 0;
                stack.push(new Cell(row, col));
                grid[row][col] = 2;     // visited

                while (!stack.isEmpty()) {
                    Cell cell = stack.pop();
                    area++;

                    for (int[] direction : directions) {
                        Cell nextCell = cell.nextCell(direction);
                        if (nextCell.inRange(rows, cols) && grid[nextCell.row][nextCell.col] == 1) {
                            stack.push(nextCell);
                            grid[nextCell.row][nextCell.col] = 2;
                        }
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    grid[row][col] = 1;
                }
            }
        }

        return maxArea;
    }

    private record Cell(int row, int col) {

        Cell nextCell(int[] direction) {
            return new Cell(row + direction[0], col + direction[1]);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

    }

}
