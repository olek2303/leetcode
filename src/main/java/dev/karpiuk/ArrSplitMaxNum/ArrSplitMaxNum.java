package dev.karpiuk.ArrSplitMaxNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrSplitMaxNum {

    public int maxSubarrays(int[] nums) {
        int sum = 0;
        ArrayList<Integer> listNums = new ArrayList<>();
        for (int num : nums) {
            listNums.add(num);
        }

        int i = 0;
        int currentAnd = -1;
        while (i < listNums.size()) {
            int elem = listNums.get(i);

            if (elem == 0) {
                sum++;
                currentAnd = -1;
                listNums.remove(i);
                continue;
            }

            currentAnd &= elem;

            if (currentAnd == 0) {
                sum++;
                currentAnd = -1;
                listNums.subList(0, i + 1).clear();
                i = 0;
            } else {
                i++;
            }
        }

        return sum > 0 ? sum : 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,0,1,2};
//        int[] nums = new int[]{0,0};
//        int[] nums = new int[]{30,18,19,20,11,21,12,22,26};
//        int[] nums = new int[]{5,7,1,3};

        System.out.println(new ArrSplitMaxNum().maxSubarrays(nums));
    }

}
