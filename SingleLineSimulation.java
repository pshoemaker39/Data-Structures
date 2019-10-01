package csc402;

import java.util.Random;
import java.util.*;

import algs13.Queue;

public class SingleLineSimulation {
	
	public static int generateCustomer(int ap) {
		int target = ((int) (Math.random()*ap)+1);
		if(target == ap) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		
		Queue<Integer> q = new Queue<Integer>();
		List<Integer> serverTimes = new ArrayList<Integer>();
		
		serverTimes.add(0);
		serverTimes.add(0);
		serverTimes.add(0);
		serverTimes.add(0);
		
		final int simt = 3600;
		final int sn = 4;
		final int st = 150;  
		final int ap = 30;
		
		int currentTime = 0;
		int customerWaitTime = 0;
		int totalWaitTime = 0;
		int totalCustomersServed = 0;

		
		//If there is time, cycle again
		while (currentTime < simt) {
			//Generate, then queue a customer
			if (generateCustomer(ap)==1) {
				//Enqueue time, proxy for customer
				q.enqueue(currentTime);
			}
			
			
			//for each server
			for(int i = 0; i < serverTimes.size(); i++) {
				
				//if server wait time is zero
				if(serverTimes.get(i)==0) {
					//server is available
					if(!q.isEmpty()) {
						customerWaitTime = currentTime - q.dequeue();
						totalWaitTime += customerWaitTime;
						totalCustomersServed++;
						serverTimes.set(i, st);
					}
				} else {
					serverTimes.set(i, serverTimes.get(i)-1);
				}
				
			}
			
			currentTime++;
		}
	
		System.out.println("Total Wait Time: "+totalWaitTime);
		System.out.println("Customers Served: "+totalCustomersServed);
		System.out.println("Average Wait Time: "+(totalWaitTime / totalCustomersServed));
		System.out.println("Number of Customers Still Queued: " + q.size());
		
	}
}
