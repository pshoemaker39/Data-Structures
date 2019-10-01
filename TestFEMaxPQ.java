package csc402;

import java.util.Arrays;
import java.util.Random;

public class TestFEMaxPQ {
	
	public static int[] fillRandom(int length) {
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = new Random().nextInt(1000 + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] targets = {1000,2000,4000,8000};
		for (int i = 0; i<targets.length; i++) {
			int[] target = fillRandom(targets[i]);;
			FEMaxPQ <Integer> mPQ = new FEMaxPQ<Integer>(target.length);
			
			for(int x = 0; x<target.length; x++) {
				mPQ.insert(target[x]);
			}
			
			while(!mPQ.isEmpty()) {
				mPQ.delMax();
			}
			
			
			System.out.println("Array length: "+target.length);
			System.out.println("Sink Swim Counter: "+mPQ.ssCounter());
			System.out.println("n lg(n): "+(mPQ.ssCounter())*Math.log((double) mPQ.ssCounter()));
			System.out.println("\n");
			
		}
	}

}
