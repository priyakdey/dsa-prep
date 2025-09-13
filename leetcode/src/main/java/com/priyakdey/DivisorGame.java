package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class DivisorGame {

    // NOTES:
    // If n is even → Alice always wins (she can force Bob to get odd)
    // If n is odd → Alice loses (only move makes n even for Bob)

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

}
