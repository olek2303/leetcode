package dev.karpiuk.MaxSubstrThrice;

import java.util.HashMap;
import java.util.Map;

public class MaxSubstrThrice {

    private boolean isSpecial(String s) {
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != first) return false;
        }
        return true;
    }

    public int maximumLength(String s) {
        int maxLen = -1;
        int actLen = s.length();

        while(actLen > 0) {

            Map<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i <= s.length() - actLen; i++) {
                String subst = s.substring(i, i + actLen);

                if (isSpecial(subst)) {
                    hashmap.put(subst, hashmap.getOrDefault(subst, 0) + 1);
                }
            }

            boolean found = false;
            for (int count : hashmap.values()) {
                if (count >= 3) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxLen = actLen;
                break;
            }

            actLen -= 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaxSubstrThrice mst = new MaxSubstrThrice();
        String s = "aaaa";
        int maxLen = mst.maximumLength(s);

        System.out.println(maxLen);
    }

}
