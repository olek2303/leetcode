package dev.karpiuk.FairPairs;

import java.util.Arrays;

public class FairPairs {

    private long getMorePairs(int[] nums, int idx, int lower, int upper) {
        long res = 0;

        int[] sortedNums = new int[nums.length - idx - 1];
        for (int i = 0; i < sortedNums.length; i++) {
            sortedNums[i] = nums[idx + i + 1];
        }
        Arrays.sort(sortedNums);
        System.out.println("NUMS: " + Arrays.toString(nums));
        System.out.println("SORTED: " + Arrays.toString(sortedNums));

        boolean isLower = false;
        for (int i = 0; i < sortedNums.length; i++) {
            if (nums[idx] + sortedNums[i] >= lower) {
                isLower = true;
            }
            if (nums[idx] + sortedNums[i] >= lower && nums[idx] + sortedNums[i] <= upper) {
                res += 1;
            }
            else if (isLower) {
                break;
            }
        }

        return res;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += getMorePairs(nums, i, lower, upper);
        }
        return result;
    }

    public static void main(String[] args) {
        FairPairs fairPairs = new FairPairs();
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        System.out.println(fairPairs.countFairPairs(nums, lower, upper));
    }

}
