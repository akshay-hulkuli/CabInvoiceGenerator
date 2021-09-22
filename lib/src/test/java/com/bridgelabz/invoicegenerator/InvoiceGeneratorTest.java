package com.bridgelabz.invoicegenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator;
	@Before
	public void init() {
		invoiceGenerator = new InvoiceGenerator();
	}
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalfare() {
		double distance =2.0;
		int time = 5;
		double fare  = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25,fare,0.0);
	}
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumfare() {
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnTotalfare() {
		Ride[] rides = { new Ride(10, 3),
						 new Ride(15, 2)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(255,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(10, 3),
						 new Ride(15, 2)
					   	};
		InvoiceSummary invoiceSummary  = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,255,127.5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
