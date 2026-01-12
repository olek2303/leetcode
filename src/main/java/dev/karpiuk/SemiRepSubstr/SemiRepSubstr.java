package dev.karpiuk.SemiRepSubstr;

public class SemiRepSubstr {

    public int longestSemiRepetitiveSubstring(String s) {
        int maxLength = 1;

        int left = 0;
        int adjacentPairCount = 0;

        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                adjacentPairCount++;
            }

            while (adjacentPairCount > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    adjacentPairCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "52233";
        SemiRepSubstr srs = new SemiRepSubstr();
        int longest = srs.longestSemiRepetitiveSubstring(s);
        System.out.println(longest);

    }

}
