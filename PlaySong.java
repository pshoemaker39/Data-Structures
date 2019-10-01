package csc402;

import stdlib.*;

public class PlaySong {
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}
	
	public static void playTones(double[] a) {
		
		for (int i = 0; i < a.length; i++) {
			playTone(a[i], 0.25);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	String toneSource = "data/a2song.txt";
        final In in = new In(toneSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + toneSource);
            System.exit (1);
        }

        double[] tones = in.readAllDoubles();
        
		playTones(tones);
		
	}

}
