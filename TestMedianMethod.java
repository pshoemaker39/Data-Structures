/*
 Price Shoemaker Depaul CSC 403
 */

package csc403;

import algs32.BST;
import algs33.RedBlackBST;
import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.Stopwatch;

public class TestMedianMethod {
    /*
    medianPuts(keyArray, valueArray)
      BST = a new BST
      BST = medianPuts(BST, keyArray, valueArray, 0, keyArray length - 1)
      return BST
    end

    medianPuts(BST, keyArray, valueArray, left, right)
      if left > right then return BST
      middle = (left + right) / 2
      put keyArray[middle] and valueArray[middle] into BST
      BST = medianPuts(BST, keyArray, valueArray, left, middle-1)
      BST = medianPuts(BST, keyArray, valueArray, middle+1, right)
      return BST
    end

     */

    public static BST<String, Integer> medianPuts(String[] k, Integer[] v) {
        BST<String, Integer> testBST = new BST<>();
        testBST = medianPuts(testBST, k, v, 0, k.length-1);
        return testBST;
    }

    public static BST<String, Integer> medianPuts(BST bst, String[] k, Integer[] v, Integer left, Integer right) {

        if(left > right) {
            return bst;
        }

        Integer middle = (left + right)/2;
        bst.put(k[middle], v[middle]);

        bst = medianPuts(bst, k, v, left, middle-1);
        bst = medianPuts(bst, k, v, middle+1, right);

        return bst;
    }

    public static void main(String args[]) {

        StdIn.fromFile("data/WordCounts.txt");
        String[] rawWords = StdIn.readAllStrings();

        String[] keys = new String[rawWords.length/2];
        Integer[] values = new Integer[rawWords.length/2];

        int a = 0;
        int b = 0;

        for (int i = 0; i < rawWords.length; i++) {

            if(i%2 == 0) {
                keys[a] = rawWords[i];
                a++;
            } else {
                values[b] = Integer.parseInt(rawWords[i]);
                b++;
            }
        }

        Stopwatch watchA = new Stopwatch();
        medianPuts(keys, values);
        double aTime = watchA.elapsedTime();
        StdOut.println("Elapsed time for filling a BST with fill by median: "+aTime);

        Stopwatch watchB = new Stopwatch();
        BST<String, Integer> slowBST = new BST<>();
        for (int i = 0; i < keys.length; i++) {
            slowBST.put(keys[i], values[i]);
        }
        double bTime = watchB.elapsedTime();
        StdOut.println("Elapsed time for filling a BST with a sorted word list: "+bTime);

        Stopwatch watchC = new Stopwatch();
        RedBlackBST<String, Integer> rbBST = new RedBlackBST<>();
        for (int i = 0; i < keys.length; i++) {
            rbBST.put(keys[i], values[i]);
        }
        double cTime = watchC.elapsedTime();
        StdOut.println("Elapsed time for filling a red-black tree with a sorted word list: "+cTime);








    }
}
