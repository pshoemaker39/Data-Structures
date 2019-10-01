package csc403;

//Write a program called TimeSymbolTables that creates two symbol tables, one created with the
//class SequentialSearchST in the package algs31 and one created with the class BST in the package algs32.
//Each symbol table will contain as a key a word read from a text file and as a value the number of times that word occurs in the text file.
//Have the program fill the first symbol table with these counts, keeping track of how long that takes using a Stopwatch object, found in the stdlib package.
//It then does the same thing with the second symbol table. Finally, it prints out how long it took to fill each symbol table.
//
//The program should consist of three parts:
//
//Create a String array of the words in the text file using the methods StdIn.fromFile() and StdIn.readAllStrings().
//Create the SequentialSearchST symbol table and then iterate through the String array created in step 1, adding to and updating words in the symbol table.
//Just before the iterating loop, create a Stopwatch object. Just after, use the elapseTime() method to get and print the amount of time.
//Create the BST symbol table and then iterate through the String array created in step 1, adding to and updating words in the symbol table.
//Just before the iterating loop, create a Stopwatch object. Just after, use the elapseTime() method to get and print the amount of time.
//Please test your program on the text file in data/tale.txt.

import algs31.BinarySearchST;
import algs31.SequentialSearchST;
import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.Stopwatch;

public class TimeSymbolTables {

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> sst = new SequentialSearchST<>();
        BinarySearchST<String, Integer> bst = new BinarySearchST<>();

        StdIn.fromFile("data/tale.txt");
        String[] rawWords = StdIn.readAllStrings();

        Stopwatch watchA = new Stopwatch();
        for(String word: rawWords) {
            if(sst.contains(word)) {
                int count = sst.get(word);
                sst.put(word, count+1);
            } else {
                sst.put(word, 1);
            }
        }
        double ssTTime = watchA.elapsedTime();
        StdOut.println("Sequential Search Symbol Table took: "+ ssTTime);

        Stopwatch watchB = new Stopwatch();
        for(String word: rawWords) {
            if(bst.contains(word)) {
                int count = bst.get(word);
                bst.put(word, count+1);
            } else {
                bst.put(word, 1);
            }
        }
        double bstTime = watchB.elapsedTime();


        StdOut.println("Binary Search Symbol Table took: "+ bstTime);

    }
}

