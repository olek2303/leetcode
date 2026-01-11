package dev.karpiuk.MinAbsDiff;

import java.util.List;
import java.util.TreeMap;

public class MinAbsDiff {

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = x; i < nums.size(); i++) {
            treeMap.merge(nums.get(i - x), 1, Integer::sum);

            Integer ceilingKey = treeMap.ceilingKey(nums.get(i));
            if (ceilingKey != null) {
                minDiff = Math.min(minDiff, ceilingKey - nums.get(i));
            }

            Integer floorKey = treeMap.floorKey(nums.get(i));
            if (floorKey != null) {
                minDiff = Math.min(minDiff, nums.get(i) - floorKey);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinAbsDiff minAbsDiff = new MinAbsDiff();
        List<Integer> nums = List.of(5,3,2,10,15);
        int x = 1;
        int result = minAbsDiff.minAbsoluteDifference(nums, x);
        System.out.println("Minimum absolute difference: " + result);
    }

}
