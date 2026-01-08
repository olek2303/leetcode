package dev.karpiuk.RestoreOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestoreOrder {

    public int[] recoverOrder(int[] order, int[] friends) {
        Map<Integer, Integer> positionMap = new HashMap<>();

        for (int i = 0; i < order.length; i++) {
            positionMap.put(order[i], i);
        }

        int[] result = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            result[i] = positionMap.get(friends[i]);
        }

        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            result[i] = order[result[i]];
        }

        return result;
    }

    public int[] recoverOrder2(int[] order, int[] friends) {
        int[] result = new int[friends.length];

        boolean[] isFriend = new boolean[order.length + 1];
        for (int friend : friends) {
            isFriend[friend] = true;
        }
        int index = 0;
        for (int value : order) {
            if (isFriend[value]) {
                result[index++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] order = {3,1,2,5,4};
        int[] friends = {1,3,4};
        RestoreOrder restoreOrder = new RestoreOrder();
        int[] result = restoreOrder.recoverOrder(order, friends);
        System.out.println("Recovered order: " + Arrays.toString(result));
    }

}
