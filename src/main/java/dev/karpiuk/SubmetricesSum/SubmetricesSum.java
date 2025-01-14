package dev.karpiuk.SubmetricesSum;

public class SubmetricesSum {

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] s = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1];
                if (s[i][j] <= k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { {7, 6, 3}, {6, 6, 1} };
        int k = 18;
        System.out.println(new SubmetricesSum().countSubmatrices(grid, k));
    }

}
