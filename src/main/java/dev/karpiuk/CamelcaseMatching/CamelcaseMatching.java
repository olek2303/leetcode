package dev.karpiuk.CamelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        for (String q : queries) {
            res.add(isMatch(q, pattern));
        }

        return res;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0, j = 0;

        while (i < query.length()) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(query.charAt(i))) {
                return false;
            }
            i++;
        }

        return j == pattern.length();
    }

    public static void main(String[] args) {
        CamelcaseMatching camelcaseMatching = new CamelcaseMatching();
        String[] queries = new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> result = camelcaseMatching.camelMatch(queries, pattern);
        for (Boolean b : result) {
            System.out.println(b);
        }
    }

}
