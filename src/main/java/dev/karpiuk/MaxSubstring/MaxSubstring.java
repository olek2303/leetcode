package dev.karpiuk.MaxSubstring;

public class MaxSubstring {
    public int maxRepeating(String sequence, String word) {
        int wordLength = word.length();
        int sequenceLength = sequence.length();

        int maxRepeating = 0;

        for (int i = 0; i <= sequenceLength - wordLength; i++) {
            int k = 0;
            while (i + k * wordLength + wordLength <= sequenceLength &&
                    sequence.substring(i + k * wordLength, i + (k + 1) * wordLength).equals(word)) {
                k++;
            }
            maxRepeating = Math.max(maxRepeating, k);
        }

        return maxRepeating;
    }

    public static void main(String[] args) {
        MaxSubstring maxSubstring = new MaxSubstring();
        System.out.println(maxSubstring.maxRepeating("ababc", "ab"));
    }
}
