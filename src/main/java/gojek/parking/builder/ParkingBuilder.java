package gojek.parking.builder;

import gojek.entities.Parking;
import gojek.entities.SingleDimensionalParkingLot;

/**
 * Builder class to build a Parking Space
 * @author agarg
 *
 */
public class ParkingBuilder {
	
	public static Parking buildParkingLot(int n){
		Parking p = null;
		if(n <=0){
			return p;
		}
		p = new SingleDimensionalParkingLot(n);
		return p;
	}

}