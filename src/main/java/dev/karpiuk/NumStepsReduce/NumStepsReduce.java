package dev.karpiuk.NumStepsReduce;

public class NumStepsReduce {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num != 0) {
            if (num % 2 != 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        int num = 14;
        NumStepsReduce nsr = new NumStepsReduce();
        int steps = nsr.numberOfSteps(num);
        System.out.println(steps);
    }
}
