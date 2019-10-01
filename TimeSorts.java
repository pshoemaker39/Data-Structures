package csc402;
import java.util.Arrays;
import algs21.Insertion;
import algs21.Selection;
import algs23.Quick;
import stdlib.*;


public class TimeSorts {
	
	public static void fillArray(Integer[] t) {
		for (int i = 0; i < t.length; i ++) {
			t[i] = ((int) (Math.random()*100)+1);	
		}
	}

	public static void main(String[] args) {
		
		double[][] sortTimes = new double [11][3];
		
		System.out.println("Length Insertion Selection Quicksort ");
		
		for (int i = 7; i < 18; i++) {
			int counter = (int) Math.pow(2, i);
			Integer[] target = new Integer[counter];
			fillArray(target);
			
			Integer[] iSort = target.clone();
			Integer[] sSort = target.clone();
			Integer[] qSort = target.clone();

			Stopwatch sw = new Stopwatch();
			Insertion.sort(iSort);
			double iswTime = sw.elapsedTime();
			Selection.sort(sSort);
			double sswTime = sw.elapsedTime() - iswTime;
			Quick.sort(qSort);
			double qswTime = sw.elapsedTime() - iswTime - sswTime;
			
			StdOut.printf("%6d%10.3f%10.3f%10.3f \n",counter, iswTime,sswTime,qswTime);
			
		}		
	}
}
