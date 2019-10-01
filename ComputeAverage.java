package csc403;

import stdlib.StdIn;
import stdlib.StdOut;


public class ComputeAverage {
    public static void main(String[] args) {
        StdIn.fromFile("data/100ints.txt");
        int sum = 0;
        int count = 0;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value < minimum) {
                minimum = value;
            }
            if (value > maximum) {
                maximum = value;
            }
            sum += value;
            count += 1;
        }
        double average = (double) sum / count;
        StdOut.println("The average is " + average);
        StdOut.println("The minimum is " + minimum);
        StdOut.println("The maximum is " + maximum);
    }
}