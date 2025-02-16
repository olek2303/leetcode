package dev.karpiuk.SumArray;

public class SumArray {

    public int minOperations(int k) {
        double sqrt = Math.sqrt(k);
        int f = (int)Math.floor(sqrt);
        int c = (int)Math.ceil(sqrt);
        if (f * c >= k) {
            return (f-1) + (c-1);
        } else {
            return 2*(c-1);
        }
    }

    public static void main(String[] args) {
        SumArray sumArray = new SumArray();
        System.out.println(sumArray.minOperations(3));
    }

}
