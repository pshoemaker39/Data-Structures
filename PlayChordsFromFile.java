/*
 * Price Shoemaker
 * Data Structures I - Autumn 2018-2019
 */

package csc402;
import stdlib.*;

public class PlayChordsFromFile {
	
	public static void playChord(double... frequencies) {
		System.out.println(frequencies[0]+" "+frequencies[1]+" "+frequencies[2]);
		double duration = 0.5;
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			for (double frequency: frequencies) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
			slices[i] /= frequencies.length;
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		
    	String toneSource = "data/risingchords.txt";
        final In in = new In(toneSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + toneSource);
            System.exit (1);
        }
        
        while(in.hasNextLine()) {
        	String chord = in.readLine();
        	String[] chordNotes = chord.split(" ");
        	int chordLen = chordNotes.length;
        	double[] notes = new double[chordLen];
        	
        	for (int i = 0; i <chordLen; i++) {
        		notes[i] = Double.parseDouble(chordNotes[i]);
        	}
        	
        	playChord(notes);
        }
        
        
	}

}
