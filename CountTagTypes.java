package csc402;

import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class CountTagTypes {
	
	public static void isBalanced(String target) {
		int opens = 0;
		int closes = 0;
		int selfClosed = 0;
		
		String[] splits = target.split("\\s+");
		
		
		for(int i = 0; i < splits.length; i++) {
			
//			System.out.println(splits[i]);
			
			String begin1 = String.valueOf(splits[i].charAt(0));
			String begin2 = String.valueOf(splits[i].charAt(1));
			String end1 = String.valueOf(splits[i].charAt(splits[i].length()-1));
			String end2 = String.valueOf(splits[i].charAt(splits[i].length()-2));
			
//			System.out.println("Target: "+splits[i]);
//			System.out.println("B1: "+begin1);
//			System.out.println("B2: "+begin2);
//			System.out.println("E1: "+end1);
//			System.out.println("E2: "+end2);
			
			
			//(begin1 == "<") && (end1 == ">")
			
			if( (begin2.equals("/")) && (begin1.equals("<")) && (end1.equals(">")) ) {
				closes++;
			} else if ( (begin1.equals("<")) && (end1.equals(">")) && ( end2.equals("/")) ) {
				selfClosed++;
			} else if ( (begin1.equals("<")) && (end1.equals(">")) ) {
				opens++;
			}
		}
		
		System.out.println("Opens: " + opens);
		System.out.println("Closings: " + closes);
		System.out.println("Self-Closed: " + selfClosed);
		
//		System.out.println(target.charAt(0));
//		System.out.println(target.charAt(target.length()));
//		
	}

	
	public static void main(String[] args) {
	
		String dataSource = StdIn.readString();
//		String dataSource = "data/xml1.txt";
        final In in = new In(dataSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + dataSource);
            System.exit (1);
        }
		
        
		isBalanced(in.readAll());

	}

}
