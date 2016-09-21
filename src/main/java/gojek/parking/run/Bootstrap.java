package gojek.parking.run;

import gojek.enums.VehicleType;
import gojek.parking.Orchestrator.CliOrchestrator;
import gojek.parking.Orchestrator.Orchestrator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bootstrap class to read input from command line and file Input to call the
 * underlying functionality. Please note that this code is the client to the
 * carParking software and can be used to test API's written for the assignment.
 * 
 * @author agarg
 */
public class Bootstrap {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Orchestrator or = new CliOrchestrator();
		String command;
		while (true) {
			command = br.readLine();
			String[] commandArray = command.split(" ");
			String commandPrefix = commandArray[0];
			switch (commandPrefix) {
			case "create_parking_lot":
				int n = Integer.parseInt(commandArray[1]);
				or.createParkingLot(n);
				break;
			case "park":
				String regNumber = commandArray[1];
				String color = commandArray[2];
				// introduced  a vehicleType to showcase
				// how implementation can be extended
				or.ParkVehicle(regNumber, color, VehicleType.Car);													
				break;
			case "leave":
				int slotNumber = Integer.parseInt(commandArray[1]);// gets slot Number
				or.freeSlot(slotNumber);
				break;
			case "status":
				
				break;
			case "registration_numbers_for_cars_with_colour":
				break;
			case "slot_numbers_for_cars_with_colour":
				break;
			case "slot_number_for_registration_number":
				break;
			default:
				/**
				 * throwing an exception here will cause the program to stop if
				 * one does not want it to stop , please comment exception code
				 * and instead uncomment Sysout written below . In production
				 * code , one would always write exception so going with that
				 * here
				 **/
				 System.out.println("Invalid command . There is no support for this command");
			}
		}

	}


}
