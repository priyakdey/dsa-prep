package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class StringCodec {

    // NOTE: Prefix each string with its length + delimiter (e.g., 5-hello).
    // While decoding, parse length and extract substrings.
    // Robust against embedded delimiters.
    // Time: O(n) total, where n = total chars.

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append('-');
            sb.append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int length = s.length();
        int curr = 0;
        List<String> list = new ArrayList<>();

        while (curr < length) {
            int start = curr;
            while (curr < length && s.charAt(curr) != '-') {
                curr++;
            }

            try {
                int substringLength = Integer.parseInt(s.substring(start, curr));
                curr++;     // skip the delimiter
                if (curr + substringLength > length) {
                    throw new IllegalArgumentException("invalid input");
                }

                String substring = s.substring(curr, curr + substringLength);
                list.add(substring);
                curr += substringLength;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid input");
            }
        }

        return list;
    }

}
