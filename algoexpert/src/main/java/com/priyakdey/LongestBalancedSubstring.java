package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class LongestBalancedSubstring {

    public int longestBalancedSubstring_quadratic(String string) {
        int length = string.length();
        List<String> substrings = new ArrayList<>(length * length);

        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                substrings.add(string.substring(i, j));
            }
        }

        for (String substring : substrings) {
            int weight = 0;
            int substringLength = substring.length();
            for (int i = 0; i < substringLength; i++) {
                weight += substring.charAt(i) == '(' ? 1 : -1;
                if (weight < 0) {
                    break;
                }
            }

            if (weight == 0) {
                maxLength = Math.max(maxLength, substringLength);
            }
        }

        return maxLength;
    }

    public int longestBalancedSubstring_cubic(String string) {
        int maxLength = 0;

        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                int weight = 0;
                for (int k = i; k < j; k++) {
                    weight += string.charAt(k) == '(' ? 1 : -1;
                    if (weight < 0) break;
                }
                if (weight == 0) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }

}
