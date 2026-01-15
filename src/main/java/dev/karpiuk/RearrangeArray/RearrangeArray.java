package dev.karpiuk.RearrangeArray;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> positiveValues = new ArrayList<Integer>();
        ArrayList<Integer> negativeValues = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positiveValues.add(nums[i]);
            } else {
                negativeValues.add(nums[i]);
            }
        }

        int p = 0, n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = positiveValues.get(p++);
            } else {
                nums[i] = negativeValues.get(n++);
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        RearrangeArray ar = new RearrangeArray();
        int[] nums = {-3,2,-1,5,-3};
        int[] rearranged = ar.rearrangeArray(nums);
        System.out.println(Arrays.toString(rearranged));
    }

}
