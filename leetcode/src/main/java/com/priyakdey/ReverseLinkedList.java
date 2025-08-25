package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ReverseLinkedList {

    // NOTE: Use three pointers:
    // - curr (current node)
    // - prev (previous node)
    // - next (to not lose reference)
    //
    // Reverse links in-place.
    // Time: O(n), Space: O(1) — classic and optimal.

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next  == null) return head;

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

    public ListNode recursive(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return recursive(next, curr);
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
