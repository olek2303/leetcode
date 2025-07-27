package dev.karpiuk.MinWindowSubstr;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // map to keep count of appearance of letters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, minLength = Integer.MAX_VALUE, matched = 0;
        int minStart = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);

            if (tMap.containsKey(endChar) && windowMap.get(endChar).intValue() <= tMap.get(endChar).intValue()) {
                matched++;
            }

            // when all letters in t are matched
            while (matched == t.length()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);

                if (tMap.containsKey(startChar) && windowMap.get(startChar).intValue() < tMap.get(startChar).intValue()) {
                    matched--;
                }

                start++;
            }

            end++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        MinWindowSubstr minWindowSubstr = new MinWindowSubstr();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindowSubstr.minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Expected output: "BANC"
    }

}
