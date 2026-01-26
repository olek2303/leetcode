package dev.karpiuk.DivArrMinCost;

public class DivArrMinCost {
    public int minimumCost(int[] nums) {
        int minCost = Integer.MAX_VALUE;

        int firstElemNums = nums[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int actCost = firstElemNums + nums[i] + nums[j];
                if (actCost < minCost) {
                    minCost = actCost;
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,12};
        DivArrMinCost darmc = new DivArrMinCost();
        int minCost = darmc.minimumCost(nums);
        System.out.println(minCost);
    }
}
