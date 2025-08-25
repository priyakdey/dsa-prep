package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class DynamicArray {

    private int[] elements;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be > 0");
        }

        this.elements = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return elements[i];
    }

    public void set(int i, int n) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        elements[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }

        elements[size++] = n;
    }

    public int popback() {
        if (size == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        return elements[--size];
    }

    private void resize() {
        capacity = capacity << 1;
        elements = Arrays.copyOf(elements, capacity);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
