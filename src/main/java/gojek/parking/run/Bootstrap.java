package gojek.parking.run;

import gojek.entities.Parking;
import gojek.entities.ParkingStatus;
import gojek.entities.Vehicle;
import gojek.parking.builder.VehicleBuilder;
import gojek.parking.contract.ParkingManager;
import gojek.parking.contract.impl.ParkingManagerImpl;
import gojek.parking.exceptions.GoJekException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bootstrap class to read input from command line and file Input
 * to call the underlying functionality. Please note that this code is
 * the  client to the carParking software and can be used to test API's written 
 * for the assignment.
 * @author agarg
 */
public class Bootstrap {

	public static void main(String[] args) throws IOException, GoJekException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ParkingManager pm = new ParkingManagerImpl();
		Parking p = null;
		Vehicle v = null;
		String command;
		while(true){
		   command = br.readLine();
		   String[] commandArray = command.split(" ");
		   String commandPrefix = commandArray[0];
		   switch(commandPrefix){
		   case "create_parking_lot":
			      int n = Integer.parseInt(commandArray[1]);
			      p = pm.createParkingLot(n);
			      if(p != null){
			    	  System.out.println("Created a parking lot with " + n + "slots");
			      }else{
			    	  System.out.println("Could not create Parking lot");
			      }
			      break;
		   case  "park":
			      String regNumber = commandArray[1];
			      String color = commandArray[2];
			      v = VehicleBuilder.buildCar(regNumber, color);
			      if(p != null){
			    	  pm.ParkVehicle(p, v);
			      }else{
			    	  throw new GoJekException("Parking lot not found");
			      }
			      break;
		   case "leave":
			     int i = Integer.parseInt(commandArray[1]);//gets slot Number
			     if(p!=null){
			    	 pm.unPark(p, i);
			     }else{
			    	 throw new GoJekException("Parking lot not found");
			     }
			     break;
		   case "status":
			   //get Status 
			   if(p!=null){
				 ParkingStatus ps =   pm.getStatusforParking(p);
				 printParkingStatus(ps);
			   }else{
				   throw new GoJekException("Parking lot not found");
			   }	   
			   break;
		   default:
			   /**throwing an exception here will cause the program to stop 
			   **if one does not want it to stop , please comment exception code and instead
			   **uncomment Sysout written below . In production code , one would always write exception so 
			   **going with that here **/
			  // System.out.println("Invalid command . There is no support for this command");
			   throw new GoJekException("Invalid command . There is no support for this command"); 
		   }
		}

	}

	/**
	 * Method to print parking status .
	 * @param ps
	 */
	private static void printParkingStatus(ParkingStatus ps) {
		
		
	}

}