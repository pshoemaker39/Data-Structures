package csc402;

import stdlib.In;
import stdlib.StdOut;

public class Distribution {
	
	public static double[] sdBuckets(double[] list, float mean, float stdev) {
		double[] bucketPercents = new double[3];
		bucketPercents[0] = 0;
		bucketPercents[1] = 0;
		bucketPercents[2] = 0;
		
		for(int i = 0; i < list.length; i++) {
			
			
			if( (list[i] < (mean+stdev)) && (list[i] > (mean-stdev)) ) {
				bucketPercents[0] += 1.0;
				
			}
			if ( (list[i] < (mean+(stdev*2))) && (list[i] > (mean-(stdev*2))) ) {
				bucketPercents[1] += 1.0;
				
			}
			if ( (list[i] < (mean+(stdev*3))) && (list[i] > (mean-(stdev*3))) ) {
				bucketPercents[2] += 1.0;
				
			}
			
		}
		
		bucketPercents[0] = (double) (bucketPercents[0] / list.length)*100;
		bucketPercents[1] = (double) (bucketPercents[1] / list.length)*100;
		bucketPercents[2] = (double) (bucketPercents[2] / list.length)*100;
		
		
		return bucketPercents;
	}
	
	public static float mean(double[] list) {
		double sum = 0;
		for(int i = 0; i < list.length; i++) {
			sum +=list[i];
		}
		return (float) (sum/list.length);
	}
	
	public static float sDev(double[] list, float mean) {

		float[] vars = new float[list.length];
		float v = 0;
		
		for(int i = 0; i < list.length; i++) {
			float target = (float) list[i];
			vars[i] = (float) Math.pow( (target-mean) , 2);
		}
		
		for(int i = 0; i < vars.length; i++) {
			v += vars[i];
		}
		
		return (float) Math.sqrt((v/vars.length));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	String dataSource = "data/normaldistribution.txt";
        final In in = new In(dataSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + dataSource);
            System.exit (1);
        }

        double[] list = in.readAllDoubles();
        float avg = mean(list);
        float stdev = sDev(list, avg);
        double[] sdBuckets = sdBuckets(list, avg, stdev);
        
        StdOut.print("The mean is "+avg+"\n");
        StdOut.print("The standard deviation is "+stdev+"\n");
        StdOut.print("Percentage of values 1 SD away from mean: "+sdBuckets[0]+"\n");
        StdOut.print("Percentage of values 2 SD away from mean: "+sdBuckets[1]+"\n");
        StdOut.print("Percentage of values 3 SD away from mean: "+sdBuckets[2]+"\n");
        

	}

}
