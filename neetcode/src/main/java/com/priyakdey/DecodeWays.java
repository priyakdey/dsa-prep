    package com.priyakdey;

    /**
     * @author Priyak Dey
     */
    public class DecodeWays {

        // A string consisting of uppercase english characters can be encoded to a number using the
        // following mapping:
        //  'A' -> "1"
        //  'B' -> "2"
        //  ...
        //  'Z' -> "26"
        //
        // To decode a message, digits must be grouped and then mapped back into letters using the
        // reverse of the mapping above. There may be multiple ways to decode a message.
        // For example, "1012" can be mapped into:
        //  - "JAB" with the grouping (10 1 2)
        //  - "JL" with the grouping (10 12)
        //
        // The grouping (1 01 2) is invalid because 01 cannot be mapped into a letter since it
        // contains a leading zero.
        //
        // Given a string s containing only digits, return the number of ways to decode it.
        // You can assume that the answer fits in a 32-bit integer.

        // Use top-down DP with memoization to count all valid decodings.
        // At each index:
        //      Decode 1 digit if it’s not '0'
        //      Decode 2 digits if the number formed is between "10" and "26"
        //
        // Base case: return 1 if index reaches end.
        // Memoize results in cache[index] to avoid recomputation.

        public int numDecodings(String s) {
            Integer[] cache = new Integer[s.length() + 1];
            return numDecodings(s, 0, cache);
        }

        private int numDecodings(String s, int index, Integer[] cache) {
            if (index == s.length()) return 1;

            if (s.charAt(index) == '0') {
                return 0;
            }

            if (cache[index] != null) return cache[index];

            int ways = numDecodings(s, index + 1, cache);

            if (s.charAt(index) == '1' && index < s.length() - 1) {
                ways += numDecodings(s, index + 2, cache);
            } else if (s.charAt(index) == '2' && index < s.length() - 1 &&
                    "0123456".indexOf(s.charAt(index + 1)) != -1) {
                    ways += numDecodings(s, index + 2, cache);
            }

            cache[index] = ways;
            return ways;
        }


    }
