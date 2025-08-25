package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReorderList {

    // NOTE: Find middle (slow/fast pointer), reverse second half, merge both halves alternately.
    // Time: O(n), Space: O(1) — in-place reordering.

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head2 = reverse(head2);

        ListNode curr1 = head.next;
        ListNode curr2 = head2;
        ListNode curr = head;

        while (curr1 != null && curr2 != null) {
            curr.next = curr2;
            curr = curr.next;
            curr.next = curr1;
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode curr = head;
        ListNode mid = head;

        while (curr != null && curr.next != null) {
            mid = mid.next;
            curr = curr.next.next;
        }

        return mid;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
