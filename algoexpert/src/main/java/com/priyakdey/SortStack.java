package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class SortStack {

    // NOTE: Sort Stack Using Auxiliary Stack (Recursive Insertion Sort):
    // Use an auxiliary temp stack to maintain sorted order
    // Recursively remove elements from stack, and insert into temp in sorted position
    // Finally, reverse temp back into original stack
    //
    // Time: O(n²) (worst case nested inserts), Space: O(n) (aux stack)

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        ArrayList<Integer> temp = new ArrayList<>(stack.size());
        sortStack(stack, temp);

        while (!temp.isEmpty()) {
            stack.add(temp.removeLast());
        }

        return stack;
    }

    private void sortStack(ArrayList<Integer> stack, ArrayList<Integer> temp) {
        if (stack.isEmpty()) return;

        int value = stack.removeLast();

        while (!temp.isEmpty() && value > temp.get(temp.size() - 1)) {
            stack.add(temp.removeLast());
        }

        temp.add(value);
        sortStack(stack, temp);
    }

}
