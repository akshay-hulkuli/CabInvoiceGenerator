package com.bridgelabz.invoicegenerator;

import java.util.*;
public class RideRepository {
	private Map<String, ArrayList<Ride>> rideRepositoryMap = new HashMap<String, ArrayList<Ride>>();
	
	public void addUserRide(String userId, Ride ride) {
		if(!rideRepositoryMap.containsKey(userId)) {
			rideRepositoryMap.put(userId, new ArrayList<Ride>());
		}
		rideRepositoryMap.get(userId).add(ride);
	}
	
	public ArrayList<Ride> getUserRideList(String userId){
		
		if(rideRepositoryMap.containsKey(userId)) return rideRepositoryMap.get(userId);
		else {
			System.err.println("User ID not found");
			return null;
		}
	}
}
