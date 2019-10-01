package csc403;


import algs31.BinarySearchST;
import stdlib.StdAudio;
import stdlib.StdIn;


public class PlayChords {
    public static void playChordForOneSecond(double... frequencies) {
        final int sliceCount = (int) (StdAudio.SAMPLE_RATE * 1);
        final double[] slices = new double[sliceCount+1];
        for (int i = 0; i <= sliceCount; i++) {
            for (double frequency: frequencies) {
                slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
            }
            slices[i] /= frequencies.length;
        }
        //StdOut.println("Playing: "+frequencies[0]+" "+frequencies[1]+" "+frequencies[2]);
        StdAudio.play(slices);
    }


    public static void main(String[] args) {

        BinarySearchST<String, Double> noteLookup = new BinarySearchST<String, Double>();

        StdIn.fromFile("data/notes_frequencies.txt");

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] lookupValues = line.split("\\s+");
            String note = lookupValues[0];
            double frequency = Double.parseDouble(lookupValues[1]);
            noteLookup.put(note, frequency);
        }

        StdIn.fromFile("data/3_note_chords.txt");

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] lookupValues = line.split("\\s+");
            String chord1 = lookupValues[0];
            String chord2 = lookupValues[1];
            String chord3 = lookupValues[2];
            double frequency1 = noteLookup.get(chord1);
            double frequency2 = noteLookup.get(chord2);
            double frequency3 = noteLookup.get(chord3);
            PlayChords.playChordForOneSecond(frequency1, frequency2, frequency3);
        }

    }

}
