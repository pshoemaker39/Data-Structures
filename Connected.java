/*
 * Price Shoemaker
 * Data Structures I - Autumn 2018-2019
 */

package csc402;

import stdlib.In;
import stdlib.StdOut;

import java.util.Arrays;

import algs15.QuickUnionUF;

public class Connected {
	
	public static int getCityIndex(String city, String[] cities) {
		for (int i = 0; i <cities.length; i++) {
			if(city.equals(cities[i])) return i;
		}
		return 99;
	}

	public static void main(String[] args) {
    	String citySource = "data/citieslist.txt";
    	String connSource = "data/connections.txt";
    	String checkSource = "data/checkconnection.txt";
        final In cityIn = new In(citySource);
        final In connIn = new In(connSource);
        final In checkIn = new In(checkSource);
        if (!cityIn.exists ()) {
        	StdOut.println("Unable to open the text source " + citySource);
            System.exit (1);
        }
        if (!connIn.exists ()) {
        	StdOut.println("Unable to open the text source " + connSource);
            System.exit (1);
        }
        String[] cities = new String[16];
        int[][] conns = new int[13][2];
        int a = 0;
        int b = 0;
        while(cityIn.hasNextLine()) {
        	cities[a] = cityIn.readLine();
        	a++;
        }
        
        while(connIn.hasNextLine()) {
        	String line = connIn.readLine();
        	String[] cityConns = line.split(" ");
        	
        	conns[b][0] = getCityIndex(cityConns[0], cities);
        	conns[b][1] = getCityIndex(cityConns[1], cities);
        	b++;
        }
        
        QuickUnionUF uf = new QuickUnionUF(16);
        
        for (int i=0; i<conns.length; i++ ) {
        	int p = conns[i][0];
        	int q = conns[i][1];
        	
    		if (uf.connected(p, q)) continue;
    		uf.union(p, q);
        	
        }
        
        while(checkIn.hasNextLine()) {
        	String line = checkIn.readLine();
        	String[] checkConns = line.split(" ");
        	
        	int p = getCityIndex(checkConns[0], cities);
        	int q = getCityIndex(checkConns[1], cities);
        	
        	if (uf.connected(p, q)) {
        		System.out.println(checkConns[0]+" and "+checkConns[1]+" ARE connected.");;
        	} else {
        		System.out.println(checkConns[0]+" and "+checkConns[1]+" ARE NOT connected.");
        	}
        	
        }
        
//        System.out.println(getCityIndex("Nashville", cities));
//        System.out.println(getCityIndex("Cincinnati", cities));        
//        System.out.println(uf.connected(12, 2));
        
        

	}

}
