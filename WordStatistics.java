package csc402;

import stdlib.In;
import stdlib.StdOut;
import java.util.*;

public class WordStatistics {
	
	public static float mean(int[] wordLengths) {
		double sum = 0;
		for(int i = 0; i < wordLengths.length; i++) {
			sum +=wordLengths[i];
		}
		return (float) (sum/wordLengths.length);
	}
	
	public static double median(int[] list) {
		Arrays.sort(list);
		double med = 0;
		if(list.length % 2 ==0) {
			int m1 = list[(list.length/2)];
			int m2 = list[(list.length/2)-1];
			med = (m1+m2)/2;
		} else {
			med = list[(int)list.length/2];
		}
		
		return med;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String dataSource = "data/tale.txt";
        final In in = new In(dataSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + dataSource);
            System.exit (1);
        }
        String[] list = in.readAllStrings();
        
        int[] wordLengths = new int[list.length]; 
        
        for (int i = 0; i < wordLengths.length; i++) {
        	String currentWord = list[i]; 
        	wordLengths[i] = currentWord.length();
        }
        
        double avgWordLength = mean(wordLengths);
        double medWordLength = median(wordLengths);
        
        StdOut.print("The average word length is "+(double)avgWordLength+" characters.");
        StdOut.print("\n");
        StdOut.print("The median word length is "+medWordLength+" characters.");
        
        
        
        
        
        
        
        
	}

}
