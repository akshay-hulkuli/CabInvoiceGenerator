package com.bridgelabz.invoicegenerator;

public class InvoiceSummary {
	private final int totalNumberOfRides;
	private final double totalFare;
	private final double averageFare;
	
	public InvoiceSummary(int totalNumberOfRides, double totalFare, double averageFare) {
		this.totalNumberOfRides = totalNumberOfRides;
		this.totalFare = totalFare;
		this.averageFare = averageFare;
	}
	
	public int getTotalNumberOfRides() {
		return totalNumberOfRides;
	}
	public double getTotalFare() {
		return this.totalFare;
	}
	public double getAverageFare() {
		return this.averageFare;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( this == obj) return true;
		if( obj == null || getClass() != obj.getClass()) return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return totalNumberOfRides == that.totalNumberOfRides && Double.compare(totalFare, that.totalFare) == 0 && Double.compare(averageFare, that.averageFare) == 0;
	}
	
	
	
}
