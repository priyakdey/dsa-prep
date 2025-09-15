package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaximumNumberOfWordsYouCanType {

    // NOTES:
    // Represent broken letters as a bitfield:
    // For each char c in brokenLetters, set bit at position c - 'a'.
    // Split text into words.
    // For each word, check all characters; if any char’s bit is set in bitfield → skip word.
    // Count words without broken letters

    public int canBeTypedWords(String text, String brokenLetters) {
        int bitfield = 0;
        for (char c : brokenLetters.toCharArray()) {
            int offset = c - 97;
            bitfield = (bitfield | (1 << offset));
        }


        String[] words = text.split("\\s");
        int count = 0;

        for (String word: words) {
            boolean consider = true;
            for (char ch : word.toCharArray()) {
                int offset = ch - 97;
                if (((bitfield >>> offset) & 1) == 1) {
                    consider = false;
                    break;
                }
            }

            if (consider) count++;
        }

        return count;
    }

}
