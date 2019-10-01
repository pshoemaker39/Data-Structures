// Price Shoemaker DePaul Data Structures II

package csc403;

//Reads the words in the file data/tale.txt into an array using the StdIn.readAllStrings() method.
//        Fills a A3SimplerBST symbol table object with counts of words in that array.

//        It should also keep a count of the number of unique words
//        by adding 1 to a counter whenever a word is first added to the symbol table.

//        Prints the unique word count, which also is the number of nodes in the BST.

//        Calls the twoChildrenCount method for the A3SimplerBST symbol table and prints the value returned.

//        Calls the sameValueCount method for the A3SimplerBST symbol table to count and
//        print how many words occur once and then again how many words occur 5 times.

import stdlib.StdIn;
import stdlib.StdOut;

public class TestA3 {

    public static void main(String[] args) {


        StdIn.fromFile("data/tale.txt");
        String[] rawWords = StdIn.readAllStrings();
        A3SimplerBST<String, Integer> bst = new A3SimplerBST<String, Integer>();
        Integer firstWord = 0;

        for(String word: rawWords) {
            if(bst.contains(word)) {
                int count = bst.get(word);
                bst.put(word, count+1);
            } else {
                bst.put(word, 1);
                firstWord += 1;
            }
        }

        StdOut.println("Number of unique words: "+firstWord);
        StdOut.println("Number of two-child nodes: "+bst.twoChildrenCount());
        StdOut.println("Number of words that appear once: "+bst.sameValueCount(1));
        StdOut.println("Number of words that appear once: "+bst.sameValueCount(5));


        //Integer[] testArray = {62, 50, 25, 75, 100, 37, 55, 88, 43, 38, 98, 45};
//        Integer[] testArrayA = {62, 50, 25, 75, 100, 37, 43};
//        Integer[] testArrayB = {1000, 1000, 1000, 4000, 6000, 6000, 6000};
//
//        A3SimplerBST<Integer, Integer> bst = new A3SimplerBST<Integer, Integer>();
//
//        for(int i = 0; i < testArrayA.length; i++) {
//            bst.put(testArrayA[i], testArrayB[i]);
//        }
//
//        StdOut.println("\n");
//
//
//
//
//        int countsA = bst.twoChildrenCount();
//
//        StdOut.println("Counts: "+countsA);
//
//        int countsB = bst.sameValueCount(1000);
//
//        StdOut.println("Counts: "+countsB);

//        try{
//            Thread.sleep(1000);
//            bst.drawTree();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }


    }
}
