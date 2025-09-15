package com.priyakdey;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Priyak Dey
 */
public class MergeKSortedLists {

    // NOTES:
    // Use a min-heap (priority queue) to always pick the smallest head among k lists.
    // Pop each node and push in the next node in the chain

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.offer(node.next);
            }

            node.next = null;
            curr.next = node;
            curr = curr.next;
        }

        return dummyHead.next;
    }

    private static class ListNode {
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
