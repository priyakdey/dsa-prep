package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class NumberOfIslands {

    // NOTE: Number of Islands (BFS Flood Fill):
    // - For each unvisited land '1', start BFS, mark all connected '1's as '2'
    // - Count each BFS as a new island
    // - Finally, revert '2' back to '1' (optional restore)
    //
    // Time: O(m × n), Space: O(m × n) (queue in worst case)

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != '1') continue;

                queue.offer(new Cell(row, col));
                grid[row][col] = '2';   // mark visited
                islands++;

                while (!queue.isEmpty()) {
                    Cell cell = queue.poll();

                    for (int[] direction : directions) {
                        Cell nextCell = cell.next(direction);
                        if (nextCell.inRange(rows, cols) && grid[nextCell.row][nextCell.col] == '1') {
                            queue.offer(nextCell);
                            grid[nextCell.row][nextCell.col] = '2';     // mark visited
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


        return islands;
    }

    private record Cell(int row, int col) {

        Cell next(int[] direction) {
            return new Cell(this.row + direction[0], this.col + direction[1]);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }

}
