/*
Price Shoemaker - DePaul CSC 403 - Data Structures II
 */

package csc403;

import algs41.Graph;
import stdlib.In;
import stdlib.StdOut;

public class DFSTrace {
//
//    public static String leftPad(int n) {
//        String[] arr = new String[n];
//        Arrays.fill(arr, " ");
//        return arr.toString();
//    }

    public static void dfsPrintTrace(Graph g) {
        // *** Declare and initialize the marked array.
        boolean [] marked = new boolean[g.V()];
        dfsPrintTrace(g, 0, marked, 0);
    }
    private static void dfsPrintTrace(Graph g, int start, boolean[] marked, int indent) {

        if(marked[start] == false){
            String outA = new String(new char[indent]).replace("\0", " ");
            StdOut.println(outA+"First visit at vertex "+start+".");
        }
        indent++;
        marked[start] = true;


        for(int v : g.adj(start)) {
            if(marked[v]) {
                String outB = new String(new char[indent]).replace("\0", " ");
                StdOut.println(outB+"Visited vertex "+v+" again.");
            } else {
                dfsPrintTrace(g, v, marked, indent);
            }
        }

        indent--;
        String outC = new String(new char[indent]).replace("\0", " ");
        StdOut.println(outC+"Finished searching from "+start+".");


    }

    public static void main(String[] args) {
        In input = new In("data/tinyG.txt");
        Graph g = new Graph(input);

        dfsPrintTrace(g);
    }
}
