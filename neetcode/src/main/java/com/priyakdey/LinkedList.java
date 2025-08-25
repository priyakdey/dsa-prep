package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }

        return curr.data;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
        }
        head = node;
        size++;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node curr = head, prev = null;
        while (index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }

        if (curr == head) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        } else if (curr == tail) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                prev.next = null;
                tail = prev;
            }
        } else {
            prev.next = curr.next;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>(size);

        Node curr = head;
        while (curr != null) {
            values.add(curr.data);
            curr = curr.next;
        }

        return values;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

}
