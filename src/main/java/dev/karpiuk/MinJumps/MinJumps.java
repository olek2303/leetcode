package dev.karpiuk.MinJumps;

public class MinJumps {

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;

        int[] dp = new int[]{1, 0, 1};

        for (int i = 1; i < n; i++) {
            int obstacle = obstacles[i];

            if (obstacle > 0) {
                dp[obstacle - 1] = Integer.MAX_VALUE / 2;
            }

            for (int j = 0; j < 3; j++) {
                if (j + 1 == obstacle) continue;
                int min = dp[j];
                for (int k = 0; k < 3; k++) {
                    if (j != k && k + 1 != obstacle) {
                        min = Math.min(min, dp[k] + 1);
                    }
                }
                dp[j] = min;
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        MinJumps minJumps = new MinJumps();
        int[] obstacles = {0, 1, 2, 3, 0};
        System.out.println(minJumps.minSideJumps(obstacles));
    }

}
