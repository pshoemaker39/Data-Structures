//Author: Price Shoemaker
package csc403;

// Write a program called CountRisingFalling that reads a file containing integers,
// for example, the file at the pathname data/100ints.txt, and then counts and prints the number of rising and falling sequences.
// A rising sequence is a sequence of integers such that each is less than the one that follows. For example, in the integer sequence:
// 3 14 35 45 40 55 60 70
// there are two rising sequences, the first from 3 to 45, the second from 40 to 70. As with many such problems,
// there is an easy way to determine when one rising sequence ends and the next one begins.
// Falling sequences are defined in the obvious way.
//
// I suggest using the method StdIn.readAllInts() to get all of the integers at once.
// Please see the StdIn class in the stdlib package for what this method returns.
// I also suggest that you create your own small test files that you can check by hand to make sure that your code is working correctly.
// When you submit the program, though, hard code into the call to fromFile the pathname data/100ints.txt.


import stdlib.StdIn;
import stdlib.StdOut;

public class CountRisingFalling {

    public static void main(String[] args) {

        StdIn.fromFile("data/100ints.txt");
        int[] fileData = StdIn.readAllInts();

//        int[] fileData = {3,14,35,45,40,55,60,70};

        int[] sequences = {0,0};
        String state;
        Boolean stateChange = false;

        if(fileData[1] > fileData[0]) {
            state = "rising";
            sequences[0] = 1;
        } else {
            state = "falling";
            sequences[1] = 1;
        }

        for (int i = 1; i < fileData.length-1; i++) {

            if((fileData[i]>fileData[i-1]) & (state != "rising")) {
                stateChange = true;
            } else if ((fileData[i]<fileData[i-1]) & (state != "falling")) {
                stateChange = true;
            }

            if(stateChange) {
                if (fileData[i] < fileData[i + 1]) {
                    stateChange = false;
                    state = "rising";
                    sequences[0] += 1;
                } else {
                    stateChange = false;
                    state = "falling";
                    sequences[1] += 1;
                }
            }
        }
        StdOut.println("\nA total of "+sequences[0]+" rising sequences and "+sequences[1]+" falling sequences.");
    }


}
