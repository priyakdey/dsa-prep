package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class MeetingRoomsII {

    //NOTES:
    // Extract and sort all startTimes and endTimes.
    // Use two pointers:
    // If start < end → new meeting starts before the earliest ends ->
    // need new room (or reuse an empty one).
    // Else → meeting ended → free up a room.
    // Track total = max rooms needed, empty = reusable rooms freed

    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes   = new int[length];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            startTimes[i] = interval[0];
            endTimes[i]   = interval[1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int total = 1;
        int empty = 0;

        int start = 1;
        int end = 0;

        while (start < length) {
            if (startTimes[start] < endTimes[end]) {
                if (empty == 0) {
                    total++;
                } else {
                    empty--;
                }
                start++;
            } else {
                empty++;
                end++;
            }
        }

        return total;
    }

}
