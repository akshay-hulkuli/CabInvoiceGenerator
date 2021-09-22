package com.bridgelabz.invoicegenerator;

import java.util.ArrayList;

public class InvoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1; 
	private static final int MINIMUM_COST = 5;
	private static RideRepository rideRepository = new RideRepository();
	
	
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_COST);
	}
	
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.getDistance(),ride.getTime());
		}
		return totalFare;
	}
	
	public InvoiceSummary getSummary(Ride[] rides) {
		double totalFare = this.calculateFare(rides);
		int numberOfRides = rides.length;
		double averageFare = totalFare / numberOfRides;
		InvoiceSummary summary = new InvoiceSummary(numberOfRides,totalFare,averageFare);
		return summary;
	}
	
	public void addUserRide(String userId, Ride rides) {
		rideRepository.addUserRide(userId, rides);
	}
	
	public InvoiceSummary getSummaryByUserId(String userId) {
		ArrayList<Ride> rides =  rideRepository.getUserRideList(userId);
		Ride[] ridesArray = new Ride[rides.size()];
		ridesArray = rides.toArray(ridesArray);
		return this.getSummary(ridesArray);
	}

}
