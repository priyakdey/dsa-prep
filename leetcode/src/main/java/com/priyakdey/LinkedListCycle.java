package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LinkedListCycle {

    // NOTE: Linked List Cycle Detection (Floyd's Algorithm):
    // Use slow and fast pointers; if they meet, a cycle exists.
    // Time: O(n), Space: O(1) — classic tortoise and hare approach.

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        return fast == slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
