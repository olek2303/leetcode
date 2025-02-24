package dev.karpiuk.ScoreOfArrayElements;
import java.util.*;

public class ScoreOfArrayElements {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        long score = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int value = curr[0], index = curr[1];

            if (used[index]) continue;

            score += value;
            used[index] = true;
            if (index > 0) used[index - 1] = true;
            if (index < n - 1) used[index + 1] = true;
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreOfArrayElements scoreOfArrayElements = new ScoreOfArrayElements();
        int[] nums = {2, 1, 3, 4, 5, 2};
        System.out.println("Score: " + scoreOfArrayElements.findScore(nums));
    }
}
