package dev.karpiuk.ArrReduceSize;

import java.util.*;

public class ArrReduceSize {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(map.values());
        frequencies.sort(Collections.reverseOrder());

        int target = arr.length / 2;
        int removed = 0;
        int setSize = 0;

        for (int freq : frequencies) {
            removed += freq;
            setSize++;
            if (removed >= target) {
                break;
            }
        }

        return setSize;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(new ArrReduceSize().minSetSize(arr));
    }

}
