package com.bridgelabz.invoicegenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import com.bridgelabz.invoicegenerator.Ride.Ridetype;

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
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.NORMAL_RIDE);
		Assert.assertEquals(25,fare,0.0);
	}
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumfare() {
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.NORMAL_RIDE);
		Assert.assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnTotalfare() {
		Ride[] rides = { new Ride(10, 3, Ridetype.NORMAL_RIDE),
						 new Ride(15, 2, Ridetype.NORMAL_RIDE)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(255,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(10, 3, Ridetype.NORMAL_RIDE),
						 new Ride(15, 2, Ridetype.NORMAL_RIDE)
					   	};
		InvoiceSummary invoiceSummary  = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,255,127.5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	@Test
	public void givenUserID_ShouldReturnInvoiceSummary() {
		String userId = "U001";
		invoiceGenerator.addUserRide(userId,new Ride(10, 3, Ridetype.NORMAL_RIDE));
		invoiceGenerator.addUserRide(userId,new Ride(15, 2, Ridetype.NORMAL_RIDE));
		InvoiceSummary invoiceSummary = invoiceGenerator.getSummaryByUserId(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,255,127.5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	
	@Test
	public void givenUserID_WhenPreminumRide_ShouldReturnInvoiceSummary() {
		String userId = "U001";
		invoiceGenerator.addUserRide(userId,new Ride(10, 3, Ridetype.PREMIUM_RIDE));
		invoiceGenerator.addUserRide(userId,new Ride(15, 2, Ridetype.PREMIUM_RIDE));
		InvoiceSummary invoiceSummary = invoiceGenerator.getSummaryByUserId(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,385,192.5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	
	@Test
	public void givenMultipleRides_WhenPreminumRide_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(10, 3, Ridetype.PREMIUM_RIDE),
						 new Ride(15, 2, Ridetype.PREMIUM_RIDE)
					   	};
		InvoiceSummary invoiceSummary  = invoiceGenerator.getSummary(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,385,192.5);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	
	@Test
	public void givenDistanceAndTime_WhenPreminumRide_ShouldReturnTotalfare() {
		double distance =2.0;
		int time = 5;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.PREMIUM_RIDE);
		Assert.assertEquals(40,fare,0.0);
	}
	@Test
	public void givenLessDistanceAndTime_WhenPreminumRide_ShouldReturnMinimumfare() {
		double distance =0.1;
		int time = 1;
		double fare  = invoiceGenerator.calculateFare(distance, time, Ridetype.PREMIUM_RIDE);
		Assert.assertEquals(20,fare,0.0);
	}
	@Test
	public void givenMultipleRides_WhenPreminumRide_ShouldReturnTotalfare() {
		Ride[] rides = { new Ride(10, 3, Ridetype.PREMIUM_RIDE),
						 new Ride(15, 2, Ridetype.PREMIUM_RIDE)
					   	};
		double fare  = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(385,fare,0.0);
	}
	
}
