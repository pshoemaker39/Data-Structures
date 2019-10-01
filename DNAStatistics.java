// Price Shoemaker DePaul Data Structures II

package csc403;

import stdlib.StdIn;
import stdlib.StdOut;

import java.util.Arrays;


public class DNAStatistics {

    public static String countCodonsByType(A3SimplerBST bst) {
        String[] uniqueCodons = bst.keys().toString().split(" ");
        String[] codonList = new String[uniqueCodons.length];
        Integer i = 0;

        for(String codon: uniqueCodons) {
            String codonString = codon+": "+ bst.get(codon)+"   ";
            codonList[i] = codonString;
            i++;
        }

        return Arrays.toString(codonList);
    }

    public static String[] countCodons(String sequence) {
        A3SimplerBST<String, Integer> bst = new A3SimplerBST<String, Integer>();
        String[] results = new String[3];
        Integer uniques = 0;

        for (int i = 0; i < sequence.length(); i+=3) {
            String c1 = Character.toString(sequence.charAt(i));
            String c2 = Character.toString(sequence.charAt(i+1));
            String c3 = Character.toString(sequence.charAt(i+2));

            String c = c1.concat(c2).concat(c3);

            if(bst.contains(c)) {
                int count = bst.get(c);
                bst.put(c, count+1);
            } else {
                bst.put(c, 1);
                uniques += 1;
            }
        }

        results[0] = Integer.toString(sequence.length()/3);
        results[1] = Integer.toString(uniques);
        results[2] = countCodonsByType(bst);

        return results;

    }

    public static String countNucleotidesByType(String sequence) {
        A3SimplerBST<String, Integer> bst = new A3SimplerBST<String, Integer>();


        for (int i = 0; i < sequence.length(); i++){
            String c = Character.toString(sequence.charAt(i));
            if(bst.contains(c)) {
                int count = bst.get(c);
                bst.put(c, count+1);
            } else {
                bst.put(c, 1);
            }
        }

        int a = bst.get("A");
        int c = bst.get("C");
        int g = bst.get("G");
        int t = bst.get("T");

        return "A: "+a+" C: "+c+" G: "+g+" T: "+t;
    }

    public static String countNucleotides(String nucleotides) {
        return Integer.toString(nucleotides.length());

    }

    public static String getSpeciesName(String n1, String n2) {
        return n1.concat(" ").concat(n2);
    }


    public static String[] analyzeEntry(String n1, String n2, String sequence) {

        String[] results = new String[6];

        results[0] = getSpeciesName(n1, n2);
        results[1] = countNucleotides(sequence);
        results[2] = countNucleotidesByType(sequence);
        results[3] = countCodons(sequence)[0];
        results[4] = countCodons(sequence)[1];
        results[5] = countCodons(sequence)[2];


        return results;

    }

    public static void main(String[] args) {
        StdIn.fromFile("data/sequences.txt");
        String[] sequences = StdIn.readAllStrings();


        for(int i = 0; i < sequences.length; i+=3) {

            String[] results = analyzeEntry(sequences[i], sequences[i+1], sequences[i+2]);

            StdOut.println("Name: "+results[0]);
            StdOut.println("Number of nucleotides: "+results[1]);
            StdOut.println("Number of each nucleotide: "+results[2]);
            StdOut.println("Number of codons: "+results[3]);
            StdOut.println("Number of different codons: "+results[4]);
            StdOut.println("Codon List "+results[5]);
            StdOut.println("\n");

        }
    }
}
