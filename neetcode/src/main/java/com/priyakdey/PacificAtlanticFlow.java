package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class PacificAtlanticFlow {

    // You are given a rectangular island heights where heights[r][c] represents the height above
    // sea level of the cell at coordinate (r, c).
    // The islands borders the Pacific Ocean from the top and left sides, and borders the
    // Atlantic Ocean from the bottom and right sides.
    // Water can flow in four directions (up, down, left, or right) from a cell to a neighboring
    // cell with height equal or lower. Water can also flow into the ocean from cells adjacent
    // to the ocean.
    // Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans.
    // Return it as a 2D list where each element is a list [r, c] representing the row and
    // column of the cell. You may return the answer in any order.

    // Use reverse multi-source BFS from Pacific and Atlantic borders.
    // Track reachable cells where water can flow to each ocean
    // (by climbing to equal/higher neighbors), then return the intersection.

    // TODO: need to refactor the two functions.
    // Can we use one boolean[][] and work with it?

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] canFlowToPacific = canFlowToPacific(heights);
        boolean[][] canFlowToAtlantic = canFlowToAtlantic(heights);

        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> results = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (canFlowToPacific[row][col] && canFlowToAtlantic[row][col]) {
                    results.add(List.of(row, col));
                }
            }
        }

        return results;
    }

    private boolean[][] canFlowToPacific(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] canFlow = new boolean[rows][cols];

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int col = 0; col < cols; col++) {
            queue.offer(new Cell(0, col));
            canFlow[0][col] = true;
        }

        for (int row = 0; row < rows; row++) {
            queue.offer(new Cell(row, 0));
            canFlow[row][0] = true;
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);

                if (nextCell.inRange(rows, cols)
                        && !canFlow[nextCell.row][nextCell.col]
                        && heights[nextCell.row][nextCell.col] >= heights[cell.row][cell.col]) {
                    queue.offer(nextCell);
                    canFlow[nextCell.row][nextCell.col] = true;
                }
            }

        }

        return canFlow;
    }

    private boolean[][] canFlowToAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] canFlow = new boolean[rows][cols];

        Deque<Cell> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int col = 0; col < cols; col++) {
            queue.offer(new Cell(rows - 1, col));
            canFlow[rows - 1][col] = true;
        }

        for (int row = 0; row < rows; row++) {
            queue.offer(new Cell(row, cols - 1));
            canFlow[row][cols - 1] = true;
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] direction : directions) {
                Cell nextCell = cell.nextCell(direction);

                if (nextCell.inRange(rows, cols)
                        && !canFlow[nextCell.row][nextCell.col]
                        && heights[nextCell.row][nextCell.col] >= heights[cell.row][cell.col]) {
                    queue.offer(nextCell);
                    canFlow[nextCell.row][nextCell.col] = true;
                }
            }

        }

        return canFlow;
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
