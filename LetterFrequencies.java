package csc402;
import stdlib.*;

public class LetterFrequencies {
	
	public static int[] counter(String target) {
		int[] occurences = new int[26];
		
		for (char x: target.toCharArray()) {
			char y = Character.toLowerCase(x);
			int z = (int) y;
			if((z > 96) && (z < 123)) {
				occurences[z-97]++;
			}
		}
		return occurences;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dataSource = StdIn.readString();
        final In in = new In(dataSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + dataSource);
            System.exit (1);
        }
		
        
		int[] result = counter(in.readAll());
		
		StdOut.print("Please enter the pathname or URL of the book file: "+ dataSource);
		StdOut.print("\n");
		StdOut.print("Letter frequencies in "+dataSource);
		StdOut.print("\n");
		
		for(int i = 0; i < result.length; i++) {
			char letter = (char) (((char) i)+97);
			StdOut.print(letter+"     "+result[i]+"\n");
		}

	}

}
