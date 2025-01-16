package dev.karpiuk.RemAllDuplicatesString;

public class RemAllDuplicatesString {

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean finish = true;

        while (finish) {
            finish = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    finish = true;
                    i = Math.max(0, i - 2);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new RemAllDuplicatesString().removeDuplicates(s));
    }

}
