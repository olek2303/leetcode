package dev.karpiuk.BinSearch;

public class BinSearch {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int div = left + (right - left) / 2;

             System.out.println("div: " + div);
             System.out.println("left: " + left);
             System.out.println("right: " + right + "\n");

            if (nums[div] < target) {
                left = div+1;
            } else if (nums[div] > target) {
                right = div-1;
            } else if (nums[div] == target){
                return div;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinSearch bs = new BinSearch();
        int nums[] = {-1,0,3,5,9,12};
        int target = 2;
        int idx = bs.search(nums, target);
        System.out.println(idx);
    }

}
