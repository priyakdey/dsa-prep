package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class Deque {

    private Node head;
    private Node tail;
    private int size;

    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        if (size == 0) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
        size++;
    }

    public int pop() {
        if (size == 0) return -1;
        Node node = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return node.data;
    }

    public int popleft() {
        if (size == 0) return -1;
        Node node = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return node.data;
    }

    private static class Node {
        private final int data;
        private Node next;
        private Node prev;

        Node(int data) {
            this.data = data;
        }
    }

}
