package csc403;

import algs31.BinarySearchST;
import stdlib.StdIn;

public class ComputeARR {

    public static void main(String[] args) {

        String[] ratings = { "Outstanding", "Excellent",  "Better", "Average", "Worse",  "Awful", "Avoid"};
        Integer[] scores =  { 6, 5, 4, 3, 2, 1, 0 };

        BinarySearchST<String, Integer> ratingLookup = new BinarySearchST<String, Integer>();

        for (int i = 0; i < ratings.length; i++) {
            ratingLookup.put(ratings[i], scores[i]);
        }

        StdIn.fromFile("data/a1ratings.txt");
        String[] rawRatingData = StdIn.readAllStrings();
        float ratingsTotal = 0;

        for (String rawRatings: rawRatingData) {
//            StdOut.println(rawRatings);
            float rating = ratingLookup.get(rawRatings);
            ratingsTotal += rating;
        }

        float ratingsAvg = ratingsTotal / rawRatingData.length;
        System.out.println("Average Rating: " + ratingsAvg);
    }

}
