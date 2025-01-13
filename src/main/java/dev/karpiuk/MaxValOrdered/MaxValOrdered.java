package dev.karpiuk.MaxValOrdered;

public class MaxValOrdered {

    // with complexity O(n^3)
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    if (value > max) {
                        max = value;
                    }
                }
            }
        }
        return max > 0 ? max : 0;
    }

    // with compexity O(n)
    public long maximumTripletValue2(int[] nums) {
        long max, maxDiff, ans;
        max = 0;
        maxDiff = 0;
        ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, num * maxDiff);
            max = Math.max(max, num);
            maxDiff = Math.max(maxDiff, max - num);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxValOrdered maxValOrdered = new MaxValOrdered();
        int[] nums = {1,10,3,4,19};
        System.out.println(maxValOrdered.maximumTripletValue(nums));
    }
}
