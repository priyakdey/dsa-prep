package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CourseSchedule {

    // You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you
    // must take course b first if you want to take course a.
    //
    // The pair [0, 1], indicates that must take course 1 before taking course 0.
    //
    // There are a total of numCourses courses you are required to take, labeled from
    // 0 to numCourses - 1.
    //
    // Return true if it is possible to finish all courses, otherwise return false.

    // Topological sort

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int coursesCompleted = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            indegrees[index]--;
            coursesCompleted++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[index][i] == 1) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) queue.offer(i);
                }
            }
        }

        return coursesCompleted == numCourses;
    }


}
