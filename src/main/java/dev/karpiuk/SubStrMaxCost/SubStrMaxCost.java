package dev.karpiuk.SubStrMaxCost;

public class SubStrMaxCost {

//    public int countValue(String s, String chars, int[] vals) {
//        int value = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char currChar = s.charAt(i);
//            int charIndex = chars.indexOf(currChar);
//            if (charIndex != -1) {
//                value += vals[charIndex];
//            } else {
//                value += currChar - 'a' + 1;
//            }
//        }
//
//        return value;
//    }
//
//    public int maximumCostSubstring(String s, String chars, int[] vals) {
//        int maxCost = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int windowSize = i+1;
//            for (int j = 0; j < s.length(); j++) {
//                if (j + windowSize <= s.length()) {
//                    String subStr = s.substring(j, Math.min(j + windowSize, s.length()));
//                    int subStrValue = countValue(subStr, chars, vals);
//                    if (subStrValue > maxCost) {
//                        maxCost = subStrValue;
//                    }
//                }
//            }
//        }
//
//        return maxCost;
//    }

    public int[] getCharValues(String chars, int[] vals) {
        int[] costs = new int[26];
        for (int i = 0; i < 26; i++) {
            costs[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            costs[chars.charAt(i) - 'a'] = vals[i];
        }
        return costs;
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] charCosts = getCharValues(chars, vals);

        int maxCost = 0;
        int currentSubstringCost = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            int charValue = charCosts[currChar - 'a'];

            currentSubstringCost += charValue;

            if (currentSubstringCost < 0) {
                currentSubstringCost = 0;
            }

            if (currentSubstringCost > maxCost) {
                maxCost = currentSubstringCost;
            }
        }

        return maxCost;
    }

    public static void main(String[] args) {

        String s = "adaa";
        String chars = "d";
        int[] vals = {-1000};
        SubStrMaxCost subStrMaxCost = new SubStrMaxCost();
        int result = subStrMaxCost.maximumCostSubstring(s, chars, vals);
        System.out.println("Maximum cost substring: " + result);

    }


}
