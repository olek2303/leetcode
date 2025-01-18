package dev.karpiuk.StringVowels;

public class StringVowels {

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowels1 = 0, vowels2 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                vowels1++;
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                vowels2++;
            }
        }
        return vowels1 == vowels2;
    }

    public static void main(String[] args) {
        String s = "book";
        System.out.println(new StringVowels().halvesAreAlike(s));
    }

}
