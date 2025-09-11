package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BestDigit {

    // NOTE: Best Digits (Greedy + Monotonic Stack):
    // Use a StringBuilder as a stack.
    // Greedily remove smaller digits before a larger one (ch > top)
    // if deletions (numDigits) remain.
    // Trim extra digits from the end if needed.
    //
    // Time: O(n), Space: O(n)

    public String bestDigits(String number, int numDigits) {
        StringBuilder sb = new StringBuilder(number.length());

        for (char ch : number.toCharArray()) {
            while (numDigits > 0 && !sb.isEmpty() && ch > sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                numDigits--;
            }
            sb.append(ch);
        }

        while (numDigits > 0) {
            sb.deleteCharAt(sb.length() - 1);
            numDigits--;
        }

        return sb.toString();
    }

}
