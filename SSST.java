package csc403;

import stdlib.StdOut;

public class SSST {

    public static void main(String[] args) {
        A5LinearProbingHashST<String, Integer> lphst = new A5LinearProbingHashST<String, Integer>(31);

        String[] cStrings = new String[]
                {"goodbye",
                "Goodbye",
                "gOodbye",
                "goOdbye",
                "gooDbye",
                "goodBye",
                "goodbYe",
                "goodbyE",
                "hello",
                "Hello",
                "hEllo",
                "heLlo",
                "helLo",
                "hellO"};

        for (int i = 0; i < cStrings.length; i++) {
            lphst.put(cStrings[i], i);
        }

        int x = 0;
        for (String s : lphst.keys()) {
            StdOut.println(s +" "+ lphst.hashCode(s)+ " " + lphst.get(s));
            x++;
        }

    }


}
