package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RottingFruit {

    // You are given a 2-D matrix grid. Each cell can have one of three possible values:
    //  - 0 representing an empty cell
    //  - 1 representing a fresh fruit
    //  - 2 representing a rotten fruit
    // Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit,
    // then the fresh fruit also becomes rotten.
    //
    // Return the minimum number of minutes that must elapse until there are zero fresh fruits
    // remaining. If this state is impossible within the grid, return -1.

    // Use multi-source BFS from all rotten fruits (value 2) to simulate infection minute by minute.
    // Track time (minute) per cell and decrement fresh count; return max days if all infected, else -1.

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int goodFruitCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new Cell(row, col, 0));
                }
                if (grid[row][col] == 1) {
                    goodFruitCount++;
                }
            }
        }

        int minTime = 0;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            minTime = Math.max(minTime, cell.minute);

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);
                if (nextCell.inRange(rows, cols) && grid[nextCell.row][nextCell.col] == 1) {
                    queue.offer(nextCell);
                    grid[nextCell.row][nextCell.col] = 2;
                    goodFruitCount--;
                }
            }
        }

        return goodFruitCount == 0 ? minTime : -1;

    }

    private record Cell(int row, int col, int minute) {
        Cell nextCell(int[] direction) {
            return new Cell(row + direction[0], col + direction[1], minute + 1);
        }

        boolean inRange(int rows, int cols) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }
    }
}
