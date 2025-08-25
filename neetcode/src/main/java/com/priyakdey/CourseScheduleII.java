package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CourseScheduleII {

    // You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you
    // must take course b first if you want to take course a.
    //
    // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    // There are a total of numCourses courses you are required to take, labeled from
    // 0 to numCourses - 1.
    //
    // Return a valid ordering of courses you can take to finish all courses. If there are many
    // valid answers, return any of them. If it's not possible to finish all courses,
    // return an empty array.

    // Topological Sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            matrix[src][dest] = 1;
        }

        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int cursor = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            indegrees[index]--;
            order[cursor++] = index;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[index][i] == 1) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) queue.offer(i);
                }
            }
        }

        return cursor == numCourses ? order : new int[]{};
    }

}
