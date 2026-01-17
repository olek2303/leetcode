package dev.karpiuk.EvenNumDig;

public class EvenNumDig {

    public int isEven(int counter, int num) {
        if (num < 10 ) {
            counter += 1;
            return counter;
        }
        return isEven(++counter, num/10);
    }

    public int findNumbers(int[] nums) {
        int sol = 0;
        for (int num : nums) {
            int c = 0;
            int counter = isEven(c, num);
            if (counter % 2 == 0) {
                sol++;
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 100, 1032, 2345};
        EvenNumDig end = new EvenNumDig();
        int sol = end.findNumbers(nums);
        System.out.println(sol);

    }

}
