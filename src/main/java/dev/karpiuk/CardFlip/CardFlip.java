package dev.karpiuk.CardFlip;

import java.util.Arrays;

public class CardFlip {

    public int flipgame(int[] fronts, int[] backs) {
        int minInt = Integer.MAX_VALUE;

        if (fronts.length != backs.length) {
            return 0;
        }

        for (int i = 0; i < fronts.length; i++) {
            for (int k = 0; k < 2; k++) {
                int candidate = (k == 0) ? backs[i] : fronts[i];
                boolean forbidden = false;

                for (int j = 0; j < fronts.length; j++) {
                    if (fronts[j] == backs[j] && fronts[j] == candidate) {
                        forbidden = true;
                        break;
                    }
                }

                if (!forbidden) {
                    minInt = Math.min(minInt, candidate);
                }
            }
        }

        return minInt == Integer.MAX_VALUE ? 0 : minInt;
    }

    public static void main(String[] args) {
        int[] fronts = {1,1};
        int[] backs = {1,2};

        CardFlip cf = new CardFlip();
        int minVal = cf.flipgame(fronts, backs);

        System.out.println(minVal);


    }

}
