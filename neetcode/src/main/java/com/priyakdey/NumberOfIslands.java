package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class NumberOfIslands {

    // Given a 2D grid `grid` where '1' represents land and '0' represents water, count and
    // return the number of islands.
    //
    // An island is formed by connecting adjacent lands horizontally or vertically and is
    // surrounded by water. You may assume water is surrounding the grid
    // (i.e., all the edges are water).

    // Count islands in a 2D grid by BFS/DFS: for each unvisited '1', increment count and mark all
    // connected '1's as visited.

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;

                islandCount++;

                queue.offer(new Cell(row, col));
                grid[row][col] = '2';     // visited cell

                while (!queue.isEmpty()) {
                    Cell cell = queue.poll();

                    for (int[] direction : directions) {
                        Cell nextCell = cell.nextCell(direction);
                        if (nextCell.inRange(rows, cols) && grid[nextCell.row][nextCell.col] == '1') {
                            queue.offer(nextCell);
                            grid[nextCell.row][nextCell.col] = '2';
                        }
                    }
                }

            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '2') {
                    grid[row][col] = '1';
                }
            }
        }

        return islandCount;
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
