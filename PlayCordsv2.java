package csc403;

//Write a program called PlayChordsv2 to play a sequence of chords each consisting of 1 or more notes.
//
//Write the program so that it:
//
//Declares and creates a symbol table using the week1examples.SimplerBST class and fills it from the file notes_frequencies.txt, as in assignment 1;
//Reads in a chords file, where each line contains at least one but perhaps several note names where the names are separated by one or more whitespace characters.
//Create your own chord file and call it a2chords.txt. Refer to in the program with the pathname data/a2chords.txt.
//Both the notes and frequencies file and the chords file should be placed into the Eclipse data directory and read in using StdIn and the fromFile method.
//
//To process a text file where each line contains a fixed set of data fields:
//
//Use the method readLine in the StdIn class, which returns a string;
//Split the string into an array of strings using the instance method split in the String class;
//Convert the array of numeric strings into an array of numeric values using the method parseDouble in the Double class.
//As in assignment 1, use the playChordForOneSecond method defined there to play each chord. Pass as the argument the array of doubles created in the steps above.

import stdlib.StdAudio;
import stdlib.StdIn;
import stdlib.StdOut;
import week1examples.SimplerBST;

public class PlayCordsv2 {

    public static void playChordForOneSecond(double... frequencies) {
        final int sliceCount = (int) (StdAudio.SAMPLE_RATE * 1);
        final double[] slices = new double[sliceCount+1];
        for (int i = 0; i <= sliceCount; i++) {
            for (double frequency: frequencies) {
                slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
            }
            slices[i] /= frequencies.length;
        }
        String freqs = "";
        for(int i = 0; i < frequencies.length; i++) {
            freqs +=" "+frequencies[i];
        }
        StdOut.println("Playing: "+freqs);
        StdAudio.play(slices);
    }

    public static void main(String[] args) {
        SimplerBST<String, Double> noteLookup = new SimplerBST<>();

        StdIn.fromFile("data/notes_frequencies.txt");

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] lookupValues = line.split("\\s+");
            String note = lookupValues[0];
            double frequency = Double.parseDouble(lookupValues[1]);
            noteLookup.put(note, frequency);
        }

        StdIn.fromFile("data/a2_chords.txt");

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String[] targetChords = line.split("\\s+");
            int chordCount = targetChords.length;
            double[] frequencies = new double[chordCount];
            for(int i = 0; i <targetChords.length; i++) {
                frequencies[i] = noteLookup.get(targetChords[i]);
            }
            playChordForOneSecond(frequencies);
        }

    }

}
