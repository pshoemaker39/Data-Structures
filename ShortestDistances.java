/*
Price Shoemaker - DePaul CSC 403 - Data Structures II
 */

package csc403;

import algs41.BreadthFirstPaths;
import algs41.Graph;
import stdlib.StdIn;
import stdlib.StdOut;

public class ShortestDistances {

    public static void main(String[] args) {
        StdIn.fromFile("data/fecities.txt");
        String[] cities = StdIn.readAllStrings();
        A3SimplerBST<String, Integer> citiesList = new A3SimplerBST<>();

        int i = 0;
        for(String c : cities) {
            citiesList.put(c, i);
            i++;
        }

        StdIn.fromFile("data/femajorcities.txt");
        String[] majors = StdIn.readAllStrings();


        Graph g = new Graph( 28);

        StdIn.fromFile("data/feconnections.txt");
        while(StdIn.hasNextLine()) {
            String [] conn = StdIn.readLine().split(" ");

            //StdOut.println(conn[0]+": "+citiesList.get(conn[0])+" | "+conn[1]+": "+citiesList.get(conn[1]));

            g.addEdge(citiesList.get(conn[0]), citiesList.get(conn[1]));


        }

        StdOut.printf("%20s", "");
        for (String majorCity: majors) {
            StdOut.printf("%-12s", majorCity);

        }
        StdOut.println();


        for(int n = 0; n < cities.length; n++) {
            BreadthFirstPaths x = new BreadthFirstPaths(g, n);
            int chi = x.distTo(6);
            int kc = x.distTo(11);
            int mke = x.distTo(16);
            int mn = x.distTo(17);
            int stl = x.distTo(24);
            String city = cities[n];
            StdOut.printf("%20s     %3d         %3d         %3d         %3d         %3d     \n",city,chi,kc,mke,mn,stl);
        }


    }



}
